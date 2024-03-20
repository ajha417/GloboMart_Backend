package com.asite.ecommercebackend.request;

import com.asite.ecommercebackend.model.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CreateProductRequest {
    private String title;
    private int price;
    private int discountPrice;
    private int discountPercent;
    private String description;
    private int quantity;
    private String brand;
    private String color;
    private Set<Size> sizeSet = new HashSet<>();
    private String imageUrl;
    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;
}
