package com.asite.ecommercebackend.service;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Ratings;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {
    public Ratings createRating(RatingRequest req, User user) throws ProductException;
    public List<Ratings> getProductRatings(Long productId);
}
