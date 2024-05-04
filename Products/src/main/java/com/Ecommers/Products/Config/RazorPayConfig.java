package com.Ecommers.Products.Config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayConfig {

    @Value(value = "${razorPay.key.id}")
    private String razorPayKeyId;

    @Value(value = "${razorPay.key.secret}")
    private String razorPaySecretKey;

    @Bean
    public RazorpayClient razorpayClient() throws RazorpayException {
        return new RazorpayClient(razorPayKeyId,razorPaySecretKey);
    }
}
