package com.springboot.cqrs.ProductServiceCQRSPattern.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
//@Table(name = "Product")
public class ProductEntity {

    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
