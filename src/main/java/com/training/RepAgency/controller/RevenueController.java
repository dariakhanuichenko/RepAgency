package com.training.RepAgency.controller;


import com.training.RepAgency.entity.Revenue;
import com.training.RepAgency.service.BoxService;
import com.training.RepAgency.service.OrderService;
import com.training.RepAgency.service.ProductOrderService;
import com.training.RepAgency.service.RevenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BoxService boxService;

    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping(value = "/local/pay")
    public String payOrder(@RequestParam("money") Long money,
                           Model model) {
        model.addAttribute("money", money);
        log.info("{}", money);

        final String[] result = new String[1];

        String orderId = RequestContextHolder.currentRequestAttributes().getSessionId();
        orderService.getById(orderId).ifPresent(order -> {
            if (money != null) {

                revenueService.findRevenueByOrderId(orderId).ifPresent(
                        p -> {
                            if (p == 0) {
                                result[0] = "redirect/?error=false";
                            }
                            if (money >= p) {
                                revenueService.save(Revenue.builder()
                                        .payment(p)
                                        .dateTime(LocalDateTime.now())
                                        .build());
                                deletePaidProducts(orderId);
                                orderService.updateOrderSetPaid(0L, orderId);
                                log.info("{}", orderId);
                                productOrderService.deleteByOrderId(orderId);
                                model.addAttribute("payment", 0);
                                result[0] = "redirect:/?error=false&&payment=0";
                            } else {
                                result[0] = "redirect:/?error=true&&money=" + money;
                                orderService.updateOrderSetPaid((order.getPaid() + money), orderId);
                            }
                        });
            }
        });
        return result[0];
    }

    @GetMapping("/local/cancel")
    public String cancelPayment(Model model) {
        String orderId = RequestContextHolder.currentRequestAttributes().getSessionId();
        //model.addAttribute("return",orderService.getPaidById(orderId));
        productOrderService.findBoxListByOrder(orderId).forEach(c -> boxService.updateBoxSetCurrentLoad(c.getNumber1(), c.getBoxId()));
        return "redirect:/?return=" + orderService.getPaidById(orderId).orElse(0L);
    }


    @GetMapping("/manager/get-revenue")
    public String getLastRevenue(Model model) {
        String returnStr = "";
        if (revenueService.findLastRecord().isPresent()) {
            Revenue revenue = revenueService.findLastRecord().get();
            //model.addAttribute("returnMoney", revenue.getPayment());
            revenueService.deleteById(revenue.getId());
            returnStr = "redirect:/manager/empty-boxes?returnMoney=" + revenue.getPayment();
        } else returnStr = "redirect:/manager/empty-boxes";
        return returnStr;
    }

    private void deletePaidProducts(String orderId) {
        productOrderService.findProductIdAndNumberByOrderId(orderId)
                .forEach(in -> {
                            boxService.updateBoxSetCurrentLoad((boxService.findCurrentLoadByProductId(in.getId() - in.getNumber()).orElse(0)),
                                    in.getId());
                        }
                );
    }
}
