package com.training.RepAgency.controller;

import com.training.RepAgency.dto.BoxWithProductNameDTO;
import com.training.RepAgency.entity.Box;
import com.training.RepAgency.service.BoxService;
import com.training.RepAgency.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class BoxController {

    @Autowired
    private ProductService productService;


    @Autowired
    private BoxService boxService;

    @GetMapping(value = "/manager/empty-boxes")
    public String getAdminCabinet(Model model) {

        List<BoxWithProductNameDTO> boxes = boxService.findBoxByCurrentLoad(0);
        model.addAttribute("boxes", boxes);

        return "manager-empty-boxes.html";
    }

    @PostMapping(value = "/manager/add-product")
    public void addProductInBox(@RequestParam("quantity")Integer quantity, @RequestParam("id") Long boxId, Model model) {
        model.addAttribute("quantity", quantity);
        model.addAttribute("id", boxId);
        Box box = boxService.findById(boxId).get();
        if (box.getCurrentLoad() + quantity <= box.getTotalCapasity()) {
            boxService.updateBoxSetCurrentLoad(box.getCurrentLoad() + quantity, boxId);
            log.info("{}", "current load for box " + boxId + " was updated");
        } else {
            log.info("{}", "current load for box " + boxId + " wasn't updated\n number is too big");
        }
    }
}
