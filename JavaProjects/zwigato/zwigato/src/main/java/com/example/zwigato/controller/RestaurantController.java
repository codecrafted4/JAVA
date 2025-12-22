package com.example.zwigato.controller;

import com.example.zwigato.dto.response.RestaurantResponse;
import com.example.zwigato.exceptions.RestaurantNotFoundException;
import com.example.zwigato.repository.RestaurantRepository;
import com.example.zwigato.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    Logger logger = LoggerFactory.getLogger(RestaurantController.class);
    private final RestaurantService restaurantService;

    @PostMapping
     public ResponseEntity addRestaurant(@RequestParam String name, @RequestParam String location){
        RestaurantResponse response = restaurantService.addRestaurant(name,location);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity changeStatus(@RequestParam("id") int id){
        logger.info("changing status started");
        try{
                 String status = restaurantService.changeStatus(id);
                 logger.info("status changed");
                 return new ResponseEntity(status,HttpStatus.FOUND);
        }
        catch(RestaurantNotFoundException e){
            logger.info("restaurant not found");
            return new  ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/menuItems")
    public ResponseEntity getAllMenuItems(@RequestParam int restaurantId){
        try {
            return new ResponseEntity(restaurantService.getAllMenuItems(restaurantId),HttpStatus.OK);
        }
        catch(Exception e )
        {
            return new  ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
