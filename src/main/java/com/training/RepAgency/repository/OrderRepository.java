package com.training.RepAgency.repository;

import com.training.RepAgency.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(String id);

    @Modifying
    @Query(value = "update Orders u set u.paid = ? where u.id = ? ",
            nativeQuery = true)
    int updateOrderSetPaid(Long number, String orderId);

    @Query(
            value = "SELECT u.paid FROM Orders u WHERE u.id = ? ",
            nativeQuery = true)
    Optional<Long> findPaidById(String orderId);
}
