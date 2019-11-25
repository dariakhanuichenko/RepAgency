package com.training.RepAgency.repository;

import com.training.RepAgency.dto.ProductWIthNumberDTO;
import com.training.RepAgency.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductOrderRepository extends JpaRepository<ProductOrder,Long> {

    @Modifying
    @Query(
            value =
                    "insert into Product_Order (order_id, product_id,number) values (?,?,?)",
            nativeQuery = true)
    void insertProductOrder(String orderId, Long productId, int number);

    @Query(
            value = "SELECT * FROM Product_Order u WHERE u.order_id = ? and u.product_id=?",
            nativeQuery = true)
    Optional<ProductOrder> findByOrderIdAndProductId(String orderId,Long product_id);

    @Modifying
    @Query(value = "update Product_Order u set u.number = ? where u.order_id = ? and u.product_id=?",
            nativeQuery = true)
    int updateProductOrderSetNumber(int number, String orderId, Long productId);

    @Query(
            value = "SELECT * FROM Product_Order u WHERE u.order_id = ? ",
            nativeQuery = true)
    Optional<List<ProductOrder>> findProductIdAndNumberByOrderId(String orderId);

    @Modifying
    @Query(value = "delete from Product_Order u where u.order_id = ?" ,
            nativeQuery = true)
    void deleteByOrderId(String orderId);
}
