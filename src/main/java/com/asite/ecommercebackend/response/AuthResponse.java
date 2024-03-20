package com.asite.ecommercebackend.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponse {
    private String jwt;
    private String message;

    public AuthResponse(String jwt, String message) {
        this.jwt = jwt;
        this.message = message;
    }
}
