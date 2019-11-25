package com.training.RepAgency.controller;


import com.training.RepAgency.entity.Revenue;
import com.training.RepAgency.service.OrderService;
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
                            if (p == 0 ) {
                                result[0] = "redirect/?error=false";
                            }
                            if (money >= p) {
                                revenueService.save(Revenue.builder()
                                        .payment(p)
                                        .date(LocalDateTime.now())
                                        .build());
                                result[0] = "redirect:/?error=false";
                            } else {
                                result[0] = "redirect:/?error=true&&money=" + money;
                            }
                            orderService.updateOrderSetPaid((order.getPaid() + money), orderId);
                        });
            }
        });
        return result[0];
    }

    @GetMapping("/local/cancel")
    public String cancelPayment(Model model) {
        String orderId = RequestContextHolder.currentRequestAttributes().getSessionId();
        //model.addAttribute("return",orderService.getPaidById(orderId));
        return "redirect:/";
    }
}
