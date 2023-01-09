package com.springboot.cqrs.ProductServiceCQRSPattern.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {

}
