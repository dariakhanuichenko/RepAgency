package com.training.RepAgency.service;

import com.training.RepAgency.entity.Product;
import com.training.RepAgency.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private static  List<Product> items=new ArrayList<>();

    static {
        items.add(Product.builder()
                .name("Apple")
                .price(12L)
                .build());
        items.add(Product.builder()
                .name("Pear")
                .price(10L)
                .build());
        items.add(Product.builder()
                .name("Juice")
                .price(15L)
                .build());

    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id){return productRepository.findById(id);}

   // public Optional<List<BoxWithProductNameDTO>>getBoxWithProductName(Integer currentLoad){return Optional.ofNullable(productRepository.getBoxWithProductName(currentLoad));}

    @PostConstruct
    public void init(){
       items.forEach(y->productRepository.save(y));
    }
}
