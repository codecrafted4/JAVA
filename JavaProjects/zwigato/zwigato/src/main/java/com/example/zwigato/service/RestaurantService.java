package com.example.zwigato.service;

import com.example.zwigato.dto.response.MenuItemsResponse;
import com.example.zwigato.dto.response.RestaurantResponse;
import com.example.zwigato.exceptions.RestaurantNotFoundException;
import com.example.zwigato.models.MenuItems;
import com.example.zwigato.models.Restaurant;
import com.example.zwigato.repository.RestaurantRepository;
import com.example.zwigato.utility.transformers.MenuItemsTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.zwigato.utility.transformers.RestaurantTransformer.restaurantToRestaurantResponse;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(String name, String location){
        Restaurant restaurant = Restaurant.builder()
                .name(name)
                .location(location)
                .isOpen(true)
                .menuItems(new ArrayList<>())
                .build();


        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        return restaurantToRestaurantResponse(savedRestaurant);


    }

    public String changeStatus(int id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isEmpty()){
            throw new RestaurantNotFoundException("Invalid id");
        }
        Restaurant restaurant = optionalRestaurant.get();
        if(restaurant.isOpen()==true){
            restaurant.setOpen(false);
        }
        else restaurant.setOpen(true);
        restaurantRepository.save(restaurant);
        return "Status changed";

    }
    public List<MenuItemsResponse> getAllMenuItems(int restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if(restaurantOptional.isEmpty()){
            throw new RestaurantNotFoundException("invalid id");
        }
        Restaurant restaurant  = restaurantOptional.get();

        List<MenuItems> menuItems = restaurant.getMenuItems();

        List<MenuItemsResponse> menuItemsResponseList = new ArrayList<>();

        for(MenuItems menuItem: menuItems)
        {
            menuItemsResponseList.add(MenuItemsTransformer.menuItemsToMenuResponse(menuItem));
        }
        return menuItemsResponseList;

    }
}
