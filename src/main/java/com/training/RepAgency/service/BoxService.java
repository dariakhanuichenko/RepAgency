package com.training.RepAgency.service;

import com.training.RepAgency.entity.Box;
import com.training.RepAgency.entity.Product;
import com.training.RepAgency.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public Optional<Box> findByProduct(Long productId){return boxRepository.findByProduct(productId);}

    public int updateBoxSetCurrentLoad(Integer currentLoad,Long idProduct){
        return boxRepository.updateBoxOrderSetCurrentLoad(currentLoad, idProduct);
    }

    @PostConstruct
    public void init(){
        boxRepository.save( Box.builder()
        .currentLoad(5)
        .product(Product.builder()
        .id(1L).build()).build());
    }
}
