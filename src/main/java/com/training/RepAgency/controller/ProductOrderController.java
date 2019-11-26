package com.training.RepAgency.controller;

import com.training.RepAgency.entity.Box;
import com.training.RepAgency.entity.Order;
import com.training.RepAgency.entity.ProductOrder;
import com.training.RepAgency.service.BoxService;
import com.training.RepAgency.service.OrderService;
import com.training.RepAgency.service.ProductOrderService;
import com.training.RepAgency.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Optional;

@Slf4j
@Controller
public class ProductOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private ProductService productService;
    @Autowired
    private BoxService boxService;

    @GetMapping(value = "/local/buy-product")
    @Transactional
    public String buyProduct(@RequestParam("id") long productId) {
        // if product by id exists
        if (productService.getById(productId).isPresent()) {

            log.info("{}", "product exists" + productId);

            Optional<Box> box = boxService.findByProduct(productId);
            if (box.isPresent() && box.get().getCurrentLoad() > 0) {

                String orderId = RequestContextHolder.currentRequestAttributes().getSessionId();

                makeNewOrder(orderId);

                Optional<ProductOrder> productOrder = productOrderService.findByOrderIdAndProductId(orderId, productId);

                addProductToOrder(productOrder, orderId, productId, box);

            }
            log.info("{}", "end func");
        }
        return "redirect:/?error=false";
    }


    private void makeNewOrder(String orderId) {
        if (!orderService.getById(orderId).isPresent()) {
            orderService.save(Order.builder()
                    .id(orderId)
                    .paid(0L)
                    .build());
            log.info("{}", "order was created");
        }
    }

    private void addProductToOrder(Optional<ProductOrder> productOrder, String orderId, Long productId, Optional<Box> box) {
        if (productOrder.isPresent()) {
            log.info("{}", "order with this product exists");
            productOrderService.updateProductOrderSetNumber((productOrder.get().getNumber() + 1), orderId, productId);
        } else {
            log.info("{}", "order with this product  doesn't exist");
            productOrderService.save(orderId, productId, 1);
        }
        log.info("{}","addProductToOrder : "+box.get().getCurrentLoad());

        boxService.updateBoxSetCurrentLoad(box.get().getCurrentLoad()-1, productId);

    }
}