package com.training.RepAgency.controller;

import com.training.RepAgency.dto.ProductDTO;
import com.training.RepAgency.entity.Box;
import com.training.RepAgency.mapper.ProductToProductDTOMapper;
import com.training.RepAgency.service.BoxService;
import com.training.RepAgency.service.OrderService;
import com.training.RepAgency.service.ProductService;
import com.training.RepAgency.service.RevenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RevenueService revenueService;

    @Autowired
    private BoxService boxService;


    @Transactional
    @GetMapping(value = "/")
    public String getIndexPage(Model model, @RequestParam(value = "error", required = false) boolean error,
                               @RequestParam(value = "return", defaultValue = "0") Long return1) {

        List<ProductDTO> products = productService.getAll().stream().map(p -> ProductToProductDTOMapper.map(p, boxService.findByProduct(p.getId())))
                .collect(Collectors.toList());
        model.addAttribute("products", products);
        String orderId = RequestContextHolder.currentRequestAttributes().getSessionId();
        model.addAttribute("payment", revenueService.findRevenueByOrderId(orderId).orElse(0L));
        model.addAttribute("error", error);
        model.addAttribute("return", return1);
        return "index.html";
    }


}
