package com.Ecommers.Products.Service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void doPayment(String email, String phoneNumber, double amount, Long orderId) throws  Exception;
}
