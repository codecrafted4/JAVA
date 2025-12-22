package com.example.zwigato.service;

import com.example.zwigato.dto.request.CustomerRequest;
import com.example.zwigato.dto.response.CustomerResponse;
import com.example.zwigato.models.Customer;
import com.example.zwigato.repository.CustomerRepository;
import com.example.zwigato.utility.enums.Gender;
import com.example.zwigato.utility.transformers.CustomerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.zwigato.utility.transformers.CustomerTransformer.customerRequestToCustomer;
import static com.example.zwigato.utility.transformers.CustomerTransformer.customerToCustomerResponse;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRequestToCustomer(customerRequest);

        Customer savedCustomer = customerRepository.save(customer);

        return customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> customerByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customers){
            customerResponses.add(customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
