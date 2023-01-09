package com.springboot.cqrs.ProductServiceCQRSPattern.command.api.events;

import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.data.ProductEntity;
import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.data.ProductRepository;
import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.model.Product;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product")
public class ProductEventsHandler {

    private ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductEntity product=new ProductEntity();
        BeanUtils.copyProperties(event,product);
        productRepository.save(product);
    }

    @ExceptionHandler
    public void handle(Exception e) throws Exception{
        throw e;
    }
}
