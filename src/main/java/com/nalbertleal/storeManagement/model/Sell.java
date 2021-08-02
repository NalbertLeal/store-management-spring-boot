package com.nalbertleal.storeManagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Sell {
    @Id
    @SequenceGenerator(
            name = "sell_sequence",
            sequenceName = "sell_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sell_sequence"
    )
    @Column(
            name = "id",
            columnDefinition = "BIGINT",
            updatable = false
    )
    private Long id;
    @Column(
            name = "amount",
            columnDefinition = "FLOAT"
    )
    private Double amount;
    @Column(
            name = "seller",
            columnDefinition = "BIGINT"
    )
    private Long seller; // user id
//    private List<Product> products;


    public Sell() {
    }

    public Sell(Long id, Double amount, Long seller) {
        this.id = id;
        this.amount = amount;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getSeller() {
        return seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }
}
