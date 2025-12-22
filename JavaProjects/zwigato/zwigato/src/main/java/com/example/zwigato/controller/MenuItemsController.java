package com.example.zwigato.controller;

import com.example.zwigato.dto.request.RequestMenuItems;
import com.example.zwigato.models.Restaurant;
import com.example.zwigato.service.MenuItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/menuItems")
@RequiredArgsConstructor
public class MenuItemsController {

    private final MenuItemsService menuItemsService;
    @PostMapping
    public ResponseEntity addMenuItems(@RequestParam int restaurantId, @RequestBody RequestMenuItems requestMenuItems)
    {
        try{
                return new ResponseEntity(menuItemsService.addMenuItems(restaurantId,requestMenuItems), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
