package com.training.RepAgency.mapper;

import com.training.RepAgency.dto.ProductWIthNumberDTO;
import com.training.RepAgency.entity.ProductOrder;

public class ProductOrderToProductWithNumberDTO {

    public static ProductWIthNumberDTO map(ProductOrder productOrder){
        return ProductWIthNumberDTO.builder()
                .id(productOrder.getProduct().getId())
                .number(productOrder.getNumber())
                .build();
    }
}
