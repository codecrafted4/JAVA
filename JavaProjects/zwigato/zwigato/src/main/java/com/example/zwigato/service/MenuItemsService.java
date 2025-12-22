package com.example.zwigato.service;

import com.example.zwigato.dto.request.RequestMenuItems;
import com.example.zwigato.dto.response.MenuItemsResponse;
import com.example.zwigato.exceptions.RestaurantNotFoundException;
import com.example.zwigato.models.MenuItems;
import com.example.zwigato.models.Restaurant;
import com.example.zwigato.repository.MenuItemsRepository;
import com.example.zwigato.repository.RestaurantRepository;
import com.example.zwigato.utility.transformers.MenuItemsTransformer;
import com.example.zwigato.utility.transformers.RestaurantTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemsService {
    private final RestaurantRepository restaurantRepository;
    public String addMenuItems(int restaurantId, RequestMenuItems requestMenuItems) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if(optionalRestaurant.isEmpty())
        {
            throw new RestaurantNotFoundException("invalid id");
        }

        Restaurant restaurant = optionalRestaurant.get();

        MenuItems menuItems = MenuItemsTransformer.RequestMenuItemsToMenuItems(requestMenuItems);

        menuItems.getRestaurants().add(restaurant);

        restaurant.getMenuItems().add(menuItems);

        restaurantRepository.save(restaurant); //restaurant + menuItem

        return "menu item added successfully";
    }


}
