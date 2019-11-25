package com.training.RepAgency.repository;

import com.training.RepAgency.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoxRepository extends JpaRepository<Box,Long> {
    @Query(
            value = "SELECT * FROM Box u WHERE u.id_product = ? ",
            nativeQuery = true)
    Optional<Box> findByProduct(Long id);

    @Modifying
    @Query(value = "update Box u set u.current_load = ? where  u.id_product=?",
            nativeQuery = true)
    int updateBoxOrderSetCurrentLoad(Integer currentLoad,  Long productId);
}
