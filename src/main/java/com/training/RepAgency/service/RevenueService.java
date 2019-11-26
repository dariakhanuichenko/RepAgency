package com.training.RepAgency.service;

import com.training.RepAgency.entity.Revenue;
import com.training.RepAgency.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    public Optional<Long> findRevenueByOrderId(String orderId){
        return revenueRepository.findRevenueByOrderId(orderId);
    }

    public void save(Revenue revenue){ revenueRepository.save(revenue);}

    public Optional<Revenue> findLastRecord(){return revenueRepository.findLastRecord();}

    public void deleteById(Long id){revenueRepository.deleteById(id);}

    @PostConstruct
    public void init() {
        revenueRepository.save(Revenue.builder()
                .dateTime(LocalDateTime.now())
                .payment(20L)
                .id(1L)
                .build());
        revenueRepository.save(Revenue.builder()
                .dateTime(LocalDateTime.MIN)
                .payment(220L)
                .id(2L)
                .build());
    }
}
