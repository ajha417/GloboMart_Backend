package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.model.Reviews;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.ProductRepository;
import com.asite.ecommercebackend.repository.ReviewRepository;
import com.asite.ecommercebackend.request.ReviewRequest;
import com.asite.ecommercebackend.service.ProductService;
import com.asite.ecommercebackend.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;
    @Override
    public Reviews createReview(ReviewRequest request, User user) throws ProductException {
        Product product = productService.findProductById(request.getProductId());
        Reviews reviews = new Reviews();
        reviews.setUser(user);
        reviews.setProduct(product);
        reviews.setReview(request.getReview());
        reviews.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(reviews);
    }

    @Override
    public List<Reviews> getAllReview(Long productId) {
        return reviewRepository.getAllProductReviews(productId);
    }
}
