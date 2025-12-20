package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.model.Customer;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass // makes all members as static
public class CustomerTransformer {
    public static CustomerResponse customerToCustomerResponse(Customer customer){
//        CustomerResponse customerResponse = new CustomerResponse();
//        customerResponse.setName(customer.getName());
//        customerResponse.setEmail(customer.getEmail());
//        customerResponse.setCreatedAt(customer.getCreatedAt());
//        return customerResponse;
        CustomerResponse customerResponse = CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .createdAt((customer.getCreatedAt()))
                .build();
        return customerResponse;
    }
    public static  Customer customerRequestToCustomer(CustomerRequest customerRequest){
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setMobNum(customerRequest.getMobNum());
//        return customer;
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .email(customerRequest.getEmail())
                .mobNum(customerRequest.getMobNum())
                .build();
        return customer;
    }
}
