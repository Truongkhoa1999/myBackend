package com.rest_api.fs14backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePaymentById(UUID paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
