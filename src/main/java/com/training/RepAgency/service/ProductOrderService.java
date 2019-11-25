package com.training.RepAgency.service;

import com.training.RepAgency.entity.ProductOrder;
import com.training.RepAgency.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public void save(String idOrder,Long idProduct, int number){
        productOrderRepository.insertProductOrder(idOrder,idProduct,number);
    }

    public Optional<ProductOrder> findByOrderIdAndProductId(String orderId, Long productId){
        return productOrderRepository.findByOrderIdAndProductId(orderId,productId);}

        public  int updateProductOrderSetNumber(int number, String orderId, Long productId){
        return productOrderRepository.updateProductOrderSetNumber(number, orderId, productId);
        }
}
