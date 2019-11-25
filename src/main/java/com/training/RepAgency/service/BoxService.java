package com.training.RepAgency.service;

import com.training.RepAgency.dto.BoxWithProductNameDTO;
import com.training.RepAgency.entity.Box;
import com.training.RepAgency.entity.Product;
import com.training.RepAgency.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private EntityManager entityManager;

    public Optional<Box> findById(Long id) {
        return boxRepository.findById(id);
    }
    public Optional<Box> findByProduct(Long id) {
        return boxRepository.findByProduct(id);
    }

    @Transactional
    public int updateBoxSetCurrentLoad(Integer currentLoad, Long id) {
        return boxRepository.updateBoxOrderSetCurrentLoad(currentLoad, id);
    }

    public Optional<Integer> findCurrentLoadByProductId(Long productId) {
        return boxRepository.findCurrentLoadByProductId(productId);
    }

    public Optional<List<Box>> findByCurrentLoad(Integer currentLoad) {
        return boxRepository.findByCurrentLoad(currentLoad);
    }


    @SuppressWarnings("unchecked")
    public List<BoxWithProductNameDTO> findBoxByCurrentLoad(Integer currentLoad) {
        return entityManager.createNamedQuery("getBoxListByCurrentLoad")
                .setParameter(1, currentLoad)
                .getResultList();
    }

    @PostConstruct
    public void init() {
        boxRepository.save(Box.builder()
                .currentLoad(0)
                .totalCapasity(10)
                .product(Product.builder()
                        .id(1L).build()).build());
        boxRepository.save(Box.builder()
                .currentLoad(0)
                .totalCapasity(10)
                .product(Product.builder()
                        .id(2L).build()).build());
    }
}
