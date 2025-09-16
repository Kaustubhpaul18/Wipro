package com.example.cashback.service;

import com.example.cashback.entity.Customer;
import com.example.cashback.entity.Coupon;
import com.example.cashback.repository.CustomerRepository;
import com.example.cashback.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;
    private final CouponRepository couponRepo;

    public CustomerService(CustomerRepository customerRepo, CouponRepository couponRepo) {
        this.customerRepo = customerRepo;
        this.couponRepo = couponRepo;
    }

    public Optional<Customer> login(String id, String password) {
        return customerRepo.findById(id)
                .filter(c -> c.getPassword().equals(password));
    }

    public Optional<Coupon> getCoupon(String code) {
        return couponRepo.findById(code);
    }

    public void updateBalance(Customer customer, double newBalance) {
        customer.setBalance(newBalance);
        customerRepo.save(customer);
    }
}
