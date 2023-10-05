package com.wanted.preonboarding.cafe.service.handler;

import static lombok.AccessLevel.PROTECTED;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Customer {
    
    private String paymentMethod;
    private Cashier cashier;
    private Map<Beverage, Integer> orders;
    
    @Builder
    public Customer(String p, Map<Beverage, Integer> o, Cashier c) {
        this.paymentMethod = p;
        this.orders = o;
        this.cashier = c;
    }
    
    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
