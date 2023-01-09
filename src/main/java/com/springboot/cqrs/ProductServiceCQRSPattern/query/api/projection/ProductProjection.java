package com.springboot.cqrs.ProductServiceCQRSPattern.query.api.projection;

import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.data.ProductEntity;
import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.data.ProductRepository;
import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.model.Product;
import com.springboot.cqrs.ProductServiceCQRSPattern.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<Product> handle(GetProductsQuery getProductsQuery){
        List<ProductEntity> products=productRepository.findAll();
        List<Product> productList=products.stream()
                .map(p->Product
                        .builder()
                        .quantity(p.getQuantity())
                        .price(p.getPrice())
                        .name(p.getName())
                        .build())
                .collect(Collectors.toList());
        return productList;
    }
}
