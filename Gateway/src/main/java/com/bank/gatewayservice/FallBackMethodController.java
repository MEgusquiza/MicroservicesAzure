package com.bank.gatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack() {
        return "Product Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/customerServiceFallBack")
    public String clientServiceFallBack() {
        return "Customer Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/transactionServiceFallBack")
    public String salesServiceFallBack() {
        return "Transaction is taking longer than Expected." +
                " Please try again later";
    }
}
