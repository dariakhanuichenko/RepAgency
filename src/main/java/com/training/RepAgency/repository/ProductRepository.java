package com.training.RepAgency.repository;

import com.training.RepAgency.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
