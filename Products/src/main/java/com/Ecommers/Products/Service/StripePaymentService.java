package com.Ecommers.Products.Service;

import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentService implements PaymentService{

    @Override
    public void doPayment(String email, String phoneNumber, double amount, Long orderId) throws Exception {

    }
}
