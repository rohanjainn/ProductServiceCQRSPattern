package com.springboot.cqrs.ProductServiceCQRSPattern.command.api.aggregate;

import com.springboot.cqrs.ProductServiceCQRSPattern.command.api.commands.CreateProductCommand;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregate(CreateProductCommand createProductCommand) {
        //validations
        //after validation create event
    }

    public ProductAggregate() {
    }
}
