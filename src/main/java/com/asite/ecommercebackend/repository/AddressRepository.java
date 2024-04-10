package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
