package com.rest_api.fs14backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
    @Autowired PaymentService paymentService;
    @GetMapping("/")
    public List<Payment> getPayments(){
        return paymentService.getPayments();
    }
    @PostMapping("/")
    public Payment createPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }
    @DeleteMapping("/paymentId/{paymentId}")
    public void deletePaymentById (@PathVariable  UUID paymentId){
        paymentService.deletePaymentById(paymentId);
    }
}
