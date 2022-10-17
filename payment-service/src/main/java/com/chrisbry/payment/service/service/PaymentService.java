package com.chrisbry.payment.service.service;

import com.chrisbry.payment.service.ValueObject.Order;
import com.chrisbry.payment.service.ValueObject.ResponseTemplateVO;
import com.chrisbry.payment.service.entity.Payment;
import com.chrisbry.payment.service.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Payment savePayment(Payment payment) {
        log.info("Inside savePayment of Payment Service");
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        log.info("Inside getAllPayments of Payment Service");
        return paymentRepository.findAll();
    }

    public ResponseTemplateVO getPaymentWithOrder(Long paymentId) {
        log.info("Inside getPaymentWithOrder of Payment Service");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Payment payment = paymentRepository.findByPaymentId(paymentId);
        Order order = restTemplate.getForObject("http://ORDER-SERVICE/orders/" + payment.getOrderId(),Order.class);

        vo.setPayment(payment);
        vo.setOrder(order);

        return vo;
    }
}
