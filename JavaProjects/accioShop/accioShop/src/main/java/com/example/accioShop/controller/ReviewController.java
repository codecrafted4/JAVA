package com.example.accioShop.controller;

import com.example.accioShop.exception.ReviewsNotFoudException;
import com.example.accioShop.model.Review;
import com.example.accioShop.service.CustomerService;
import com.example.accioShop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    //make an API to get customer review by ID
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity addReview(@RequestBody Review review) {
        Review savedReview = reviewService.addReview(review);
        return new ResponseEntity(savedReview,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity getReviewsById (@RequestParam("id") int id){
        try{
            return new ResponseEntity(reviewService.getReviewsById(id), HttpStatus.FOUND);
        }catch (ReviewsNotFoudException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
