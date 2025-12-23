package com.example.zwigato.controller;

import com.example.zwigato.annotation.PrintHello;
import com.example.zwigato.dto.request.CustomerRequest;
import com.example.zwigato.dto.response.CustomerResponse;
import com.example.zwigato.models.Customer;
import com.example.zwigato.repository.CustomerRepository;
import com.example.zwigato.service.CustomerService;
import com.example.zwigato.utility.enums.Gender;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    @PostMapping
    @PrintHello
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){

        logger.info("customer adding started");
        CustomerResponse response  = customerService.addCustomer(customerRequest);
        logger.info("customer added");
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity customerByGender(@PathVariable Gender gender){
        List<CustomerResponse> customerResponses = customerService.customerByGender(gender);
        return new  ResponseEntity(customerResponses,HttpStatus.OK);

    }



}
