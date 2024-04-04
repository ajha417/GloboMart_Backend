package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.Ratings;
import com.asite.ecommercebackend.model.Reviews;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.request.RatingRequest;
import com.asite.ecommercebackend.request.ReviewRequest;
import com.asite.ecommercebackend.service.ReviewService;
import com.asite.ecommercebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Reviews> createReviews(@RequestBody ReviewRequest request,
                                                @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Reviews reviews = reviewService.createReview(request, user);
        return new ResponseEntity<>(reviews, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Reviews>> getProductReviews(@PathVariable Long productId,
                                                           @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(jwt);
        List<Reviews> reviewsList = reviewService.getAllReview(productId);
        return new ResponseEntity<>(reviewsList, HttpStatus.OK);
    }
}
