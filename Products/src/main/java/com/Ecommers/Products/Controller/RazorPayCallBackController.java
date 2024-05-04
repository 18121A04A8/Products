package com.Ecommers.Products.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/razorPayCallBack")
public class RazorPayCallBackController {

    @GetMapping("")
    public void callBack(){
        System.out.println("call back method");
    }
}
