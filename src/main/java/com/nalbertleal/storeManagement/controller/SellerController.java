package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.model.Seller;
import com.nalbertleal.storeManagement.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SellerController {
    @Autowired
    private SellerService sellerServicee;

    public SellerController(SellerService sellerServicee) {
        this.sellerServicee = sellerServicee;
    }

    @GetMapping("/seller/{email}")
    public Map show(@RequestParam String email) {
        try {
            return Map.of(
                    "success", true,
                    "seller", sellerServicee.getSeller(email)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @GetMapping("/sellers-from-manager/{email}")
    public Map getSellersFromManager(
            @RequestParam String email
    ) {
        try {
            return Map.of(
                    "success", true,
                    "sellers", sellerServicee.getAllSellerFromManager(email)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PostMapping("/seller")
    public Map createSeller(@RequestBody Map<String, String> body) {
        try {
            Double salary = Double.parseDouble(body.get("salary"));
            Seller user = new Seller(
                    body.get("fullname"),
                    body.get("email"),
                    body.get("password"),
                    salary,
                    body.get("manager")
            );
            return Map.of(
                    "success", true,
                    "seller", sellerServicee.createSeller(user)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PutMapping("/seller/{email}")
    public Map updateSeller(
            @RequestParam String email,
            @RequestBody Map<String, String> body
    ) {
        try {
            Double salary = Double.parseDouble(body.get("salary"));
            Seller user = new Seller(
                    body.get("fullname"),
                    body.get("email"),
                    body.get("password"),
                    salary,
                    body.get("manager")
            );
            return Map.of(
                    "success", true,
                    "seller", sellerServicee.updateSeller(email, user)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PutMapping("/seller-to-manager/{email}")
    public Map updateSellerToManager(
            @RequestParam String email
    ) {
        try {
            return Map.of(
                    "success", true,
                    "manager", sellerServicee.sellerToManager(email)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @DeleteMapping("/seller/{email}")
    public Map deleteSeller(@RequestParam String email) {
        try {
            sellerServicee.deleteSeller(email);
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
