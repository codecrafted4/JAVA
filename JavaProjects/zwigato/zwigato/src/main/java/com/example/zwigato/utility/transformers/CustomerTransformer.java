package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.request.CustomerRequest;
import com.example.zwigato.dto.response.CustomerResponse;
import com.example.zwigato.models.Customer;

import java.util.ArrayList;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .mobNum(customerRequest.getMobNum())
                .gender(customerRequest.getGender())
                .address(new ArrayList<>())
                .orders((new ArrayList<>()))
                .build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .mobNum(customer.getMobNum())
                .build();
    }
}
