package com.training.RepAgency.service;

import com.training.RepAgency.entity.Revenue;
import com.training.RepAgency.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RevenueService {

    @Autowired
    private RevenueRepository revenueRepository;

    public Optional<Long> findRevenueByOrderId(String orderId){
        return revenueRepository.findRevenueByOrderId(orderId);
    }

    public void save(Revenue revenue){ revenueRepository.save(revenue);}
}
