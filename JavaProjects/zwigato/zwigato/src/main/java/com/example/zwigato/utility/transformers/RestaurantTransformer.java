package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.response.RestaurantResponse;
import com.example.zwigato.models.Restaurant;

public class RestaurantTransformer {
    public static RestaurantResponse restaurantToRestaurantResponse(Restaurant restaurant){
        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .isOpen(restaurant.isOpen())
                .registeredAt(restaurant.getRegisteredAt())
                .build();

    }
}
