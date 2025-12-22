package com.example.zwigato.dto.request;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {
    private String house_No;


    private String city;


    private String state;


    private String pinCode;


}
