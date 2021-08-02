package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.model.Manager;
import com.nalbertleal.storeManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/manager")
    public Map show(@RequestParam String email) {
        try {
            return Map.of(
                    "success", true,
                    "seller", managerService.getManager(email)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PostMapping("/manager")
    public Map createManager(@RequestBody Map<String, String> body) {
        try {
            Manager manager = new Manager(
                    body.get("fullname"),
                    body.get("email"),
                    body.get("password"),
                    Double.parseDouble(body.get("salary"))
            );
            return Map.of(
                    "success", true,
                    "seller", managerService.createManager(manager)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PutMapping("/manager")
    public Map updateManager(
            @RequestParam String email,
            @RequestBody Map<String, String> body
    ) {
        try {
            Manager manager = new Manager(
                    body.get("fullname"),
                    body.get("email"),
                    body.get("password"),
                    Double.parseDouble(body.get("salary"))
            );
            return Map.of(
                    "success", true,
                    "seller", managerService.updateManager(email, manager)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @DeleteMapping("/manager")
    public Map deleteManager(@RequestParam String email) {
        try {
            managerService.deleteManager(email);
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
