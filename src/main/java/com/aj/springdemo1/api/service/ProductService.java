package com.aj.springdemo1.api.service;

import com.aj.springdemo1.api.model.Product;
import com.aj.springdemo1.api.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class ProductService {
    Logger logger = Logger.getLogger("ProductService.class");
    List<Product> products;
    ProductService(){
         products = new ArrayList<>();
         // TO DO add DAO layer to add/get the new product
         Product product = new Product(1,"Shoe");
         products.add(product);
    }



    public boolean checkProductAvailability(Product product){
        logger.info("Checking for the availability of the Product");

        // TO DO add DAO layer to get the value from DB
        int existingProduct = 1;
        return product != null && product.getId() == existingProduct;
    }

    public boolean payOrder(Product product) throws InterruptedException {

        logger.info("Payment service is started ");
        Thread.sleep(5000L);
        logger.info("Payment service is done ");
        return true;
    }

    public Product processProduct(Product product) throws InterruptedException {
        logger.info("Prodcut processing started!");
        //Check the availability of the product
        if (checkProductAvailability(product)){
            //Proceed for payment
            boolean isSuccess = payOrder(product);
            if (isSuccess) {
                product.setTrackingNum(generateTrackingNumber(product));
            } else {
                product.setErrorCode(generateTrackingNumber(product));
            }


        } else {
            logger.info("Unable get the product availability!!!");
            product.setErrorCode(generateTrackingNumber(product));
        }
        return product;
    }


    public String generateTrackingNumber(Product product) throws InterruptedException {
        String trackingNum = UUID.randomUUID().toString();
        logger.info("Tracking Number Generated!!! "+trackingNum);
        return trackingNum;
    }
    @Async("asyncThreadProcessor")
    public void notifyUser(Product product) throws InterruptedException {
        Thread.sleep(5000L);
        logger.info("Notified to user ");
    }
    @Async("asyncThreadProcessor")
    public void packageOrder(Product product) throws InterruptedException {
        Thread.sleep(5000L);
        logger.info("Package order is done ");
    }
    @Async("asyncThreadProcessor")
    public void deliverOrder(Product product) throws InterruptedException {
        Thread.sleep(5000L);
        logger.info("Delivered !!! ");
    }
}
