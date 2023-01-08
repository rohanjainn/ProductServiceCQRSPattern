package com.springboot.cqrs.ProductServiceCQRSPattern.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
