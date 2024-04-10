package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.CartItemException;
import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.Cart;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.request.AddItemRequest;
import com.asite.ecommercebackend.response.ApiResponse;
import com.asite.ecommercebackend.service.CartService;
import com.asite.ecommercebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req,
                         @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(),req);
        ApiResponse response = new ApiResponse();
        response.setMessage("Item added to successfully!!!");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
