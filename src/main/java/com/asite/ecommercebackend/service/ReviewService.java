package com.asite.ecommercebackend.service;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.model.Reviews;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Reviews createReview(ReviewRequest request, User user) throws ProductException;
    public List<Reviews> getAllReview(Long productId);
}
