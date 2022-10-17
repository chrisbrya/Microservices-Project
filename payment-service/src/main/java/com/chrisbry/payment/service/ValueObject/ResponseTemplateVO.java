package com.chrisbry.payment.service.ValueObject;

import com.chrisbry.payment.service.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Payment payment;
    private Order order;
}
