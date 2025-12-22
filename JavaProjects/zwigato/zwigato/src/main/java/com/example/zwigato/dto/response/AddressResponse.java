package com.example.zwigato.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {
    private String house_No;


    private String city;


    private String state;


    private String pinCode;

     private CustomerResponse customer;
}
