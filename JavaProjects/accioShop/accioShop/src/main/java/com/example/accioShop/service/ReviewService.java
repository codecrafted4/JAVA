package com.example.accioShop.service;

import com.example.accioShop.exception.ReviewsNotFoudException;
import com.example.accioShop.model.Review;
import com.example.accioShop.repository.CustomerRepository;
import com.example.accioShop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;


    public Review getReviewsById(int id) {
        Optional<Review> optionalReviews = reviewRepository.findById(id);

        if (optionalReviews.isEmpty()) {
            throw new ReviewsNotFoudException("No Reviews");
        }

        return optionalReviews.get();

    }

    public Review addReview(Review review) {
        Review savedReview=reviewRepository.save(review);
        return savedReview;

    }
}
