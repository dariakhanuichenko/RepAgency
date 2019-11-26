package com.training.RepAgency.repository;

import com.training.RepAgency.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    @Query(
            value = "SELECT sum(pr.number *p.price) FROM Product_Order pr join Product p on pr.product_id=p.id WHERE pr.order_id = ?",
            nativeQuery = true)
    Optional<Long> findRevenueByOrderId(String orderId);

    @Query(
            value="SELECT TOP 1 * FROM revenue r ORDER BY r.date_time DESC",
            nativeQuery = true
    )
    Optional<Revenue> findLastRecord();

    @Override
    void deleteById(Long id);
}
