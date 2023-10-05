package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.handler.discount.DiscountPolicy;
import com.wanted.preonboarding.cafe.service.handler.discount.MembershipDiscountPolicy;
import com.wanted.preonboarding.cafe.service.handler.discount.NoneDiscountPolicy;
import com.wanted.preonboarding.cafe.service.handler.discount.TelecomDiscountPolicy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public class Cafe {
    
    private final String name;
    private Long sales;
    
    public Cafe() {
        this.name = "wantedCodingCafe";
        this.sales = 10000L;
    }
    
    public void plusSales(Long amount) {
        this.sales += amount;
    }
    
    public void minusSales(Long amount) {
        this.sales -= amount;
    }
    
    public Long calculateTotalPrice(Map<Beverage, Integer> receivedOrders, String paymentMethod) {
    
        DiscountPolicy discountPolicy = selectDiscountPolicy(paymentMethod);
        return calculateOrderPrice(receivedOrders) * discountPolicy.calculateDiscountAmount();
    }
    
    private DiscountPolicy selectDiscountPolicy(String type) {
    
        return switch (type) {
            case "telecom" -> new TelecomDiscountPolicy();
            case "membership" -> new MembershipDiscountPolicy();
            default -> new NoneDiscountPolicy();
        };
    }
    
    private Long calculateOrderPrice(Map<Beverage, Integer> receivedOrders) {
    
        AtomicLong totalPrice = new AtomicLong(0L);
    
        receivedOrders.forEach(((beverage, quantity) ->
                totalPrice.addAndGet(beverage.calculatePrice() * quantity)));
    
        return totalPrice.get();
    }
}
