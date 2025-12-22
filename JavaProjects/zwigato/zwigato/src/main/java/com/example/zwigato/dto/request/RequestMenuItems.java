package com.example.zwigato.dto.request;

import com.example.zwigato.utility.enums.FoodCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestMenuItems {

    private int price;

    private String name;


    private FoodCategory category;


    private boolean isVeg;
}
