package com.training.RepAgency.repository;

import com.training.RepAgency.dto.BoxWithProductNameDTO;
import com.training.RepAgency.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(
            value = "SELECT new BoxWithProductNameDTO(p.name, b.id, b.total_capasity)  FROM Box b inner join Product p on p.id=b.id_product WHERE b.current_load= ? ",
            nativeQuery = true)
    List<BoxWithProductNameDTO> getBoxWithProductName(Integer currentLoad);
}
