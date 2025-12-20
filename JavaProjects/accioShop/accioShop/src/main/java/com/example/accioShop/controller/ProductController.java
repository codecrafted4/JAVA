package com.example.accioShop.controller;

import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.response.ProductResponse;
import com.example.accioShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

   @Autowired
    ProductService productService;

   @PostMapping()
    public ResponseEntity addProduct(@RequestParam("seller_id") int seller_id , @RequestBody ProductRequest productRequest){
        try{
            ProductResponse productResponse = productService.addProduct(seller_id,productRequest);
            return new ResponseEntity(productResponse,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
