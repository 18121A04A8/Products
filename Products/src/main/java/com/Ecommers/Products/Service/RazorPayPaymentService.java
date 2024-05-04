package com.Ecommers.Products.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorPay")
public class RazorPayPaymentService implements PaymentService {

    private RazorpayClient razorpayClient;

    public RazorPayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public void doPayment(String email, String phoneNumber, double amount, Long orderId) throws Exception {



        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",amount);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1",email);
        notes.put("notes_key_1",phoneNumber);
        orderRequest.put("notes",notes);

        Order order = razorpayClient.orders.create(orderRequest);
    }
}
