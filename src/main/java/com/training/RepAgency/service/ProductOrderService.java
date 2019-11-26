package com.training.RepAgency.service;

import com.training.RepAgency.dto.OrderDTO;
import com.training.RepAgency.dto.ProductWIthNumberDTO;
import com.training.RepAgency.entity.ProductOrder;
import com.training.RepAgency.mapper.ProductOrderToProductWithNumberDTO;
import com.training.RepAgency.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private EntityManager entityManager;

    public void save(String idOrder, Long idProduct, int number) {
        productOrderRepository.insertProductOrder(idOrder, idProduct, number);
    }

    public Optional<ProductOrder> findByOrderIdAndProductId(String orderId, Long productId) {
        return productOrderRepository.findByOrderIdAndProductId(orderId, productId);
    }

    public int updateProductOrderSetNumber(int number, String orderId, Long productId) {
        return productOrderRepository.updateProductOrderSetNumber(number, orderId, productId);
    }

    public List<ProductWIthNumberDTO> findProductIdAndNumberByOrderId(String orederId){
        return productOrderRepository.findProductOrderByOrderId( orederId).isPresent()?
                productOrderRepository.findProductOrderByOrderId( orederId).get().stream()
                .map(ProductOrderToProductWithNumberDTO::map).collect(Collectors.toList()):new ArrayList<>();
    }

    @Transactional
    public void deleteByOrderId(String orderId){
        productOrderRepository.deleteProductOrderByOrderId(orderId);
    }


    @SuppressWarnings("unchecked")
    public List<OrderDTO> findBoxListByOrder(String orderId) {
        return entityManager.createNamedQuery("getBoxListByOrder")
                .setParameter(1, orderId)
                .getResultList();
    }
}
