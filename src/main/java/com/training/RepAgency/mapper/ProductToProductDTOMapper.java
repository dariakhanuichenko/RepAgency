package com.training.RepAgency.mapper;

import com.training.RepAgency.dto.ProductDTO;
import com.training.RepAgency.entity.Box;
import com.training.RepAgency.entity.Product;

import java.util.Optional;

public class ProductToProductDTOMapper {

    public static  ProductDTO  map(Product product, Optional<Box> box){
        return ProductDTO.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .currentLoad(box.isPresent()?box.get().getCurrentLoad():0)
                .build();
    }
}
