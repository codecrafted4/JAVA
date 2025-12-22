package com.example.zwigato.service;

import com.example.zwigato.dto.request.AddressRequest;
import com.example.zwigato.dto.response.AddressResponse;
import com.example.zwigato.exceptions.CustomerNotFoundException;
import com.example.zwigato.models.Address;
import com.example.zwigato.models.Customer;
import com.example.zwigato.repository.AddressRepository;
import com.example.zwigato.repository.CustomerRepository;
import com.example.zwigato.utility.transformers.AddressTransformer;
import com.example.zwigato.utility.transformers.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    public AddressResponse addAddress(int customerId, AddressRequest addressRequest) {
        Optional<Customer> optionalCustomer =  customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("invalid Id");
        }
        Customer customer = optionalCustomer.get();


        Address address = AddressTransformer.addressRequestToAddress(addressRequest);

        customer.getAddress().add(address);

        Customer savedCustomer = customerRepository.save(customer);
        int sz = savedCustomer.getAddress().size();

        Address lastSavedAddress = savedCustomer.getAddress().get(sz-1);



        AddressResponse response = AddressTransformer.addressToAddressResponse(lastSavedAddress);
        response.setCustomer(CustomerTransformer.customerToCustomerResponse(savedCustomer));
        return response;
    }
}
