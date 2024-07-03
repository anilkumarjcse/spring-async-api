package com.aj.springdemo1.api.controller;

import com.aj.springdemo1.api.model.Product;
import com.aj.springdemo1.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public  ProductController (ProductService prodcutService){
        this.productService = prodcutService;
    }


    @PostMapping ("/processProduct")
    public ResponseEntity<Product> processProduct(@RequestBody Product product) throws InterruptedException {
//        This is Sequential order
        productService.processProduct(product); //(Availability, Payment, Tracking Number) these are synchronous
        productService.notifyUser(product); // Asynchronous call
        productService.packageOrder(product); // Asynchronous call
        productService.deliverOrder(product); // Asynchronous call
        return ResponseEntity.ok(product);
    }

}
