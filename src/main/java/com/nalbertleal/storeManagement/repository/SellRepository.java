package com.nalbertleal.storeManagement.repository;

import com.nalbertleal.storeManagement.model.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {
}
