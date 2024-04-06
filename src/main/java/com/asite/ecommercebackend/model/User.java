package com.asite.ecommercebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String mobile;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL) //casecadetype is all so that when user is deleted then its all addresses will be deleted
    private List<Address> addresses = new ArrayList<Address>();
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cardHolderName", column = @Column(name = "cardholder_name")),
            @AttributeOverride(name = "cardNumber", column = @Column(name = "card_number")),
            @AttributeOverride(name = "expirationDate", column = @Column(name = "expiration_date")),
            @AttributeOverride(name = "cvv", column = @Column(name = "cvv"))
    })
    private PaymentInformation paymentInformation;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ratings> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reviews> reviews = new ArrayList<>();
    private LocalDateTime createdAt;


}
