package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Beverage;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {
    
    /**
     * 고객 주문
     */
    public String orderFrom(Customer customer) {
    
        Cashier cashier = customer.getCashier();
        Map<Beverage, Integer> orders = customer.getOrders();
        String paymentMethod = customer.getPaymentMethod();
    
        return cashier.takeOrders(orders, paymentMethod);
    }
}
