package com.example.accioShop.dto.request;

import com.example.accioShop.enums.Gender;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    private String name;

    private int age;

    private String email;

    private Gender gender;

    private String mobNum;


}
