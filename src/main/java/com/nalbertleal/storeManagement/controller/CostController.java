package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.model.Cost;
import com.nalbertleal.storeManagement.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CostController {
    @Autowired
    private CostService costService;

    public CostController(CostService costService) {
        this.costService = costService;
    }

    @GetMapping("/cost")
    public Map getALl() {
        return Map.of(
                "success", true,
                "costs", costService.getAll()
        );
    }

    @PostMapping("/cost")
    public Map createCosrt(@RequestBody Map<String, String> body) {
        try {
            Cost cost = new Cost(
                    Double.parseDouble(body.get("amount")),
                    body.get("Description")
            );
            return Map.of(
                    "success", true,
                    "cosr", costService.createCost(cost)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PutMapping("/cost/{id}")
    public Map updateCost(
            @RequestParam Long id,
            @RequestBody Map<String, String> body
    ) {
        try {
            Cost cost = new Cost(
                    id,
                    Double.parseDouble(body.get("amount")),
                    body.get("description")
            );
            return Map.of(
                    "success", true,
                    "cost", costService.updateCost(cost)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @DeleteMapping("/cost")
    public Map updateCost(@RequestParam Long id) {
        try {
            costService.deleteCost(id);
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
