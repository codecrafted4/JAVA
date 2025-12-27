package com.example.zwigato.controller;

import com.example.zwigato.dto.request.OrderItemsRequest;
import com.example.zwigato.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity placeOrder(@RequestParam int customerId,
                                     @RequestBody List<OrderItemsRequest> ordertemsRequest){
        try{
            return new ResponseEntity(orderService.placeOrder(customerId,ordertemsRequest), HttpStatus.CREATED);
        }
        catch(Exception e ){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
