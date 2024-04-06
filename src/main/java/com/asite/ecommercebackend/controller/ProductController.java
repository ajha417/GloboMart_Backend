package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam String category,
    @RequestParam List<String> color, @RequestParam List<String> size, @RequestParam Integer minPrice,
     @RequestParam Integer maxPrice, @RequestParam Integer minDiscount, @RequestParam String sort,
     @RequestParam String stock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        Page<Product> res = productService.getAllProducts(category,color,size,minPrice,maxPrice,minDiscount,sort,stock,pageNumber,
                pageSize);
        System.out.println("Complete Products");
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/id/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) throws ProductException {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
    }

}
