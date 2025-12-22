package com.example.zwigato.dto.request;

import com.example.zwigato.utility.enums.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {


    private String name;


    private String mobNum;


    private Gender gender;
}
