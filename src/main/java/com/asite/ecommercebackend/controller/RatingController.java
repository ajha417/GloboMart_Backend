package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.Ratings;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.request.RatingRequest;
import com.asite.ecommercebackend.service.RatingService;
import com.asite.ecommercebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Ratings> createRating(@RequestBody RatingRequest request,
                                   @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(jwt);
        Ratings ratings = ratingService.createRating(request, user);
        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Ratings>> getProductRatings(@PathVariable Long productId,
                                         @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(jwt);
        List<Ratings> ratingsList = ratingService.getProductRatings(productId);
        return new ResponseEntity<>(ratingsList, HttpStatus.OK);
    }
}
