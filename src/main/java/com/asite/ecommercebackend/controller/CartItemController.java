package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.CartItemException;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.response.ApiResponse;
import com.asite.ecommercebackend.service.CartService;
import com.asite.ecommercebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_item")
public class CartItemController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @DeleteMapping("/{itemId}")
    public ResponseEntity<ApiResponse> removeItemFromCart(@PathVariable("itemId") Long itemId,
                                                          @RequestHeader("Authorization") String jwt)
                                                            throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.removeItemFromCart(user.getId(), itemId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Item deleted to successfully!!!");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
