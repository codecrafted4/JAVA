package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.request.RequestMenuItems;
import com.example.zwigato.dto.response.MenuItemsResponse;
import com.example.zwigato.models.MenuItems;

import java.util.ArrayList;
import java.util.List;

public class MenuItemsTransformer {

    public static MenuItems RequestMenuItemsToMenuItems(RequestMenuItems menuItems){
        return MenuItems.builder()
                .name(menuItems.getName())
                .category(menuItems.getCategory())
                .vegOrNon(menuItems.isVeg())
                .price(menuItems.getPrice())
                .restaurants(new ArrayList<>())
                .build();
    }


    public static MenuItemsResponse menuItemsToMenuResponse(MenuItems menu) {
        return MenuItemsResponse.builder()
                .name(menu.getName())
                .price(menu.getPrice())
                .isVegOrNon(menu.isVegOrNon())
                .category(menu.getCategory())
                .build();
    }
}
