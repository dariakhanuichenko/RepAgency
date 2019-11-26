package com.training.RepAgency.repository;

import com.training.RepAgency.entity.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoxRepository extends JpaRepository<Box,Long> {
    @Query(
            value = "SELECT * FROM Box u WHERE u.id_product = ? ",
            nativeQuery = true)
    Optional<Box> findByProduct(Long id);


    Optional<Box> findById(Long id);
    @Modifying
    @Query(value = "update Box  set current_load =? where  id=?",
            nativeQuery = true)
    int updateBoxOrderSetCurrentLoad(int currentLoad,  Long id);

    @Query(
            value = "SELECT u.current_load FROM Box u WHERE u.id_product = ? ",
            nativeQuery = true)
    Optional<Integer>  findCurrentLoadByProductId(Long productId);

    Optional<List<Box>> findByCurrentLoad(Integer currentLoad);
}
