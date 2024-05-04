package com.Ecommers.Products.Controller;

import com.Ecommers.Products.Dto.InitiatePaymentRequestDto;
import com.Ecommers.Products.Service.PaymentService;
import com.Ecommers.Products.Service.RazorPayPaymentService;
import com.Ecommers.Products.Service.StripePaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    RazorPayPaymentService razorPayPaymentService;
    StripePaymentService stripePaymentService;

    public PaymentController(@Qualifier("razorPay") RazorPayPaymentService razorPayPaymentService,
                                @Qualifier("stripe") StripePaymentService stripePaymentService ) {
        this.razorPayPaymentService = razorPayPaymentService;
        this.stripePaymentService = stripePaymentService;
    }

    @PostMapping("/initiate")
    public String initiate(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws Exception {

        getPaymentService().doPayment (
                initiatePaymentRequestDto.getEmail(),
                initiatePaymentRequestDto.getPhoneNumber(),
                initiatePaymentRequestDto.getAmount(),
                initiatePaymentRequestDto.getOrderId());

            return "Success";
    }

    public PaymentService getPaymentService(){
        if(Math.random()!=0){
            return razorPayPaymentService;
        }
        else{
            return stripePaymentService;
        }
    }
}
