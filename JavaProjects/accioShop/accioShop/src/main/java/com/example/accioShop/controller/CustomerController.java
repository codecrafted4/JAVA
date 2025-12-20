package com.example.accioShop.controller;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest) {

        CustomerResponse savedCustomer = customerService.addCustomer(customerRequest);
        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);

    }
    //make an API to get customer by id
    @GetMapping
    public ResponseEntity getCustomerByID(@RequestParam("id") int id) {
        try {
            CustomerResponse response = customerService.getCustomerById(id);
            return new ResponseEntity(response, HttpStatus.FOUND);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }







    //filter based on gender
    //input gender
    //output List<customer Response>


    //iput-age
    //list<customer response> ehree  age >= age
}

