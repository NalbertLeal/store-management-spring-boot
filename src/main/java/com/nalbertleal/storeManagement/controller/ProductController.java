package com.nalbertleal.storeManagement.controller;

import com.nalbertleal.storeManagement.model.Product;
import com.nalbertleal.storeManagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public Map getAll() {
        return Map.of(
                "success", true,
                "products", productService.getAllProducts()
        );
    }

    @GetMapping("/product/{id}")
    public Map show(@RequestParam Long id) {
        try {
            return Map.of(
                    "success", true,
                    "product", productService.getProduct(id)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PostMapping("/product")
    public Map create(@RequestBody Map<String, String> body) {
        try {
            Product product = new Product(
                    body.get("name"),
                    Double.parseDouble(body.get("price")),
                    Long.parseLong(body.get("stock")),
                    body.get("Description")
            );
            return Map.of(
                    "success", true,
                    "product", productService.createProduct(product)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @PutMapping("/product/{id}")
    public Map create(
            @RequestParam Long id,
            @RequestBody Map<String, String> body
    ) {
        try {
            Product product = new Product(
                    id,
                    body.get("name"),
                    Double.parseDouble(body.get("price")),
                    Long.parseLong(body.get("stock")),
                    body.get("Description")
            );
            return Map.of(
                    "success", true,
                    "product", productService.updateProduct(product)
            );
        } catch (Exception e) {
            return Map.of(
                    "success", false
            );
        }
    }

    @DeleteMapping("/product")
    public Map delete(@RequestParam Long id) {
        try {
            productService.deleteProduct(id);
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
