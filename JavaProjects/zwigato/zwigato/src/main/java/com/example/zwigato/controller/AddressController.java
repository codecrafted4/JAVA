package com.example.zwigato.controller;

import com.example.zwigato.dto.request.AddressRequest;
import com.example.zwigato.exceptions.CustomerNotFoundException;
import com.example.zwigato.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @PostMapping
    public ResponseEntity addAddress(@RequestParam int customerId, @RequestBody AddressRequest addressRequest){
        try{
        return new ResponseEntity(addressService.addAddress(customerId,addressRequest), HttpStatus.CREATED);}
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value ="/customer/{c}/address/{a}")
    public ResponseEntity deleteAddress(@PathVariable("c") int customerId, @PathVariable("a") int addressId)
    {
        try{
            return new ResponseEntity(addressService.deleteAddress(customerId,addressId),HttpStatus.FOUND);
        }catch(Exception e)
        {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/customer/{id}/addresses")
    public ResponseEntity getAllAddress(@PathVariable("id") int customerId){
        try{
            return new ResponseEntity(addressService.getAllAddress(customerId),HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
