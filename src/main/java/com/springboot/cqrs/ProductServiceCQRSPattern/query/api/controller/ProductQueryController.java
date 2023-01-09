package com.springboot.cqrs.ProductServiceCQRSPattern.query.api.controller;

import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.model.Product;
import com.springboot.cqrs.ProductServiceCQRSPattern.query.api.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<Product> getAllProducts(){

        GetProductsQuery getProductsQuery=new GetProductsQuery();
        List<Product> products=queryGateway.query(getProductsQuery,
                ResponseTypes.multipleInstancesOf(Product.class))
                .join();
        return products;
    }
}
