package com.asite.ecommercebackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;

    private String description;

    private int price;

    @Column(name = "discounted_price")
    private int discountedPrice;

    @Column(name = "discounted_percent")
    private int discountPercentage;

    private int quantity;

    private String brand;

    private String color;

    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    private Set<Size> sizes = new HashSet<>();

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Ratings> ratings = new ArrayList<>();

    @Column(name = "num_ratings")
    private int numRatings;

    @ManyToOne
    private Category category;
    private LocalDateTime createdAt;

}
