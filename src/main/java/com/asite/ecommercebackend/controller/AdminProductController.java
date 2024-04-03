package com.asite.ecommercebackend.controller;

import com.asite.ecommercebackend.exception.ProductException;
import com.asite.ecommercebackend.model.Product;
import com.asite.ecommercebackend.request.CreateProductRequest;
import com.asite.ecommercebackend.response.ApiResponse;
import com.asite.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest productRequest) {
        Product product = productService.createProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException{
        productService.deleteProduct(productId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Product deleted successfully!!!");
        response.setStatus(true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/allproducts")
    public ResponseEntity<List<Product>> findAllProduct(){
        List<Product> allProducts = productService.findAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long productId) throws ProductException{
        Product updatedProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }

    @PostMapping("/creates")
    public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] req) {
        for (CreateProductRequest productRequest: req) {
            productService.createProduct(productRequest);
        }
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Product created successfully!!!");
        apiResponse.setStatus(true);
        return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

}
