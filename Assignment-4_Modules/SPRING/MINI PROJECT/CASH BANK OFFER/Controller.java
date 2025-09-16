package com.example.cashback.controller;

import com.example.cashback.entity.Customer;
import com.example.cashback.entity.Coupon;
import com.example.cashback.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final CustomerService service;

    public LoginController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String customerId,
                        @RequestParam String password,
                        Model model) {
        Optional<Customer> customer = service.login(customerId, password);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "balance";
        } else {
            model.addAttribute("error", "Invalid CustomerID or Password");
            return "error";
        }
    }

    @PostMapping("/claim")
    public String claimOffer(@RequestParam String customerId,
                             @RequestParam String couponCode,
                             Model model) {
        Optional<Customer> customerOpt = service.login(customerId, service.login(customerId, "").map(Customer::getPassword).orElse(""));
        if (customerOpt.isEmpty()) {
            model.addAttribute("error", "Invalid session. Please login again.");
            return "error";
        }

        Customer customer = customerOpt.get();
        Optional<Coupon> couponOpt = service.getCoupon(couponCode);

        if (couponOpt.isEmpty()) {
            model.addAttribute("error", "Invalid Coupon Code");
            return "error";
        }

        Coupon coupon = couponOpt.get();
        double cashback = customer.getBalance() * coupon.getOfferPercentage() / 100.0;
        double newBalance = customer.getBalance() + cashback;

        service.updateBalance(customer, newBalance);

        model.addAttribute("customer", customer);
        model.addAttribute("cashback", cashback);
        model.addAttribute("percentage", coupon.getOfferPercentage());
        model.addAttribute("newBalance", newBalance);

        return "offer";
    }
}
