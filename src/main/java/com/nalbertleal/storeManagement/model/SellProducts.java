package com.nalbertleal.storeManagement.model;

import javax.persistence.*;

@Entity
@Table
public class SellProducts {
    @Id
    @SequenceGenerator(
            name = "sell_products_sequence",
            sequenceName = "sell_products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sell_products_sequence"
    )
    @Column(
            name = "id",
            columnDefinition = "BIGINT",
            updatable = false
    )
    private Long id;
    @Column(
            name = "sellId",
            columnDefinition = "FLOAT"
    )
    private Double sellId;
    @Column(
            name = "productId",
            columnDefinition = "FLOAT"
    )
    private Double productId;

    public SellProducts() {
    }

    public SellProducts(Double sellId, Double productId) {
        this.sellId = sellId;
        this.productId = productId;
    }

    public SellProducts(Long id, Double sellId, Double productId) {
        this.id = id;
        this.sellId = sellId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSellId() {
        return sellId;
    }

    public void setSellId(Double sellId) {
        this.sellId = sellId;
    }

    public Double getProductId() {
        return productId;
    }

    public void setProductId(Double productId) {
        this.productId = productId;
    }
}
