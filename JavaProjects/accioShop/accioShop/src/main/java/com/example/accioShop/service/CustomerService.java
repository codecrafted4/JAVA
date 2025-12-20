package com.example.accioShop.service;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.transformer.CustomerTransformer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;



    public CustomerResponse addCustomer(CustomerRequest customerRequest)
    {
        //step1: request DTO Entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        //step2: save entity
        Customer savedCustomer = customerRepository.save(customer);

        //step3: convert saved entity into response
        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(customer);

        return customerResponse;

    }
    public CustomerResponse getCustomerById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid ID");
        }
        Customer customer = optionalCustomer.get();

        CustomerResponse customerResponse = CustomerTransformer.customerToCustomerResponse(customer);

        return customerResponse;

    }

}
