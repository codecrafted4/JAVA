package com.example.zwigato.dto.response;

import com.example.zwigato.models.Restaurant;
import com.example.zwigato.utility.enums.FoodCategory;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemsResponse {
    private int price;

    private String name;


    private FoodCategory category;


    private boolean isVegOrNon;

}
