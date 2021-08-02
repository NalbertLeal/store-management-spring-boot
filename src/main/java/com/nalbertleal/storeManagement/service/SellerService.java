package com.nalbertleal.storeManagement.service;

import com.nalbertleal.storeManagement.model.Manager;
import com.nalbertleal.storeManagement.model.Seller;
import com.nalbertleal.storeManagement.repository.ManagerRepository;
import com.nalbertleal.storeManagement.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ManagerRepository managerRepository;

    public SellerService(SellerRepository sellerRepository, ManagerRepository managerRepository) {
        this.sellerRepository = sellerRepository;
        this.managerRepository = managerRepository;
    }

    public Seller getSeller(String email) {
        return sellerRepository.findByEmail(email).orElseThrow();
    }

    public Seller createSeller(Seller user) {
        managerRepository.findByEmail(user.getEmail()).orElseThrow();
        return sellerRepository.save(user);
    }

    public Seller updateSeller(String email, Seller user) {
        Seller userFromDb = sellerRepository.findByEmail(email).orElseThrow();
        user.setId(userFromDb.getId());
        return sellerRepository.save(user);
    }

    public Manager sellerToManager(String email) {
        Seller seller = sellerRepository.findByEmail(email).orElseThrow();
        sellerRepository.deleteByEmail(email);
        Manager manager = new Manager(
                seller.getFullname(),
                seller.getEmail(),
                seller.getPassword(),
                seller.getSalary()
        );
        return managerRepository.save(manager);
    }

    public List<Seller> getAllSellerFromManager(String email) {
        return sellerRepository.findByManagerEmail(email);
    }

    public void deleteSeller(String email) {
        sellerRepository.deleteByEmail(email);
    }
}
