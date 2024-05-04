package com.Ecommers.Products.Dto;

import lombok.Data;

@Data
public class InitiatePaymentRequestDto {

    private String email;
    private String phoneNumber;
    private double amount;
    private Long orderId;

}
