package com.example.accioShop.controller;

import com.example.accioShop.dto.response.OrderResponse;
import com.example.accioShop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    public ResponseEntity placeOrder(@RequestParam int customerId,@RequestParam int productId){
        try{
                 OrderResponse orderResponse = orderService.placeOrder(customerId,productId);
                 return     new ResponseEntity(orderResponse,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
