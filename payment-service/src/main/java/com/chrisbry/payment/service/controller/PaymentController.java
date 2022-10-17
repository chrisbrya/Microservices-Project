package com.chrisbry.payment.service.controller;

import com.chrisbry.payment.service.ValueObject.ResponseTemplateVO;
import com.chrisbry.payment.service.entity.Payment;
import com.chrisbry.payment.service.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public Payment savePayment(@RequestBody Payment payment){
        log.info("Inside savePayment of PaymentController");
        return paymentService.savePayment(payment);
    }

    @GetMapping("/getAllPayments")
    public List<Payment> getAllPayments(){
        log.info("Inside getAllPayments of PaymentController");
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getPaymentWithOrder(@PathVariable("id") Long paymentId){
        log.info("Inside getPaymentWithOrder of PaymentController");
        return paymentService.getPaymentWithOrder(paymentId);
    }
}
