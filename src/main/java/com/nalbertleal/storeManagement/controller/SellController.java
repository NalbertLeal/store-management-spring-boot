package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.model.Sell;
import com.nalbertleal.storeManagement.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SellController {
    @Autowired
    private SellService sellService;

    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @GetMapping("/sell/{email}")
    public Map getALLSellFromSeller(@RequestParam String email) {
        try {
            return Map.of(
                    "success", true,
                    "sells", sellService.getAllFromSeller(email)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PostMapping("/sell")
    public Map createSell(@RequestBody Map<String, String> body) {
        try {
            Sell sell = new Sell(
                    Double.parseDouble(body.get("amount")),
                    body.get("seller_email")
            );
            return Map.of(
                    "success", true,
                    "sells", sellService.createSell(sell)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PutMapping("/sell/{id}")
    public Map updateSell(
            @RequestParam Long id,
            @RequestBody Map<String, String> body
    ) {
        try {
            Sell sell = new Sell(
                    id,
                    Double.parseDouble(body.get("amount")),
                    body.get("seller_email")
            );
            return Map.of(
                    "success", true,
                    "sells", sellService.updateSell(sell)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @DeleteMapping("/sell/{id}")
    public Map deteleSell(@RequestParam Long id) {
        try {
            sellService.deleteSell(id);
            return Map.of(
                    "success", true
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }
}
