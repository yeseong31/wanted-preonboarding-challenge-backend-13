package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Cashier {
    
    private final Cafe cafe;
    private final OrderBook orderBook;
    private final Barista barista;
    
    /**
     * 주문 받기
     */
    public String takeOrders(Map<Beverage, Integer> orders, String paymentMethod) {
        
        // 판매 금액 계산 요청 -> Beverage
        Long price = cafe.calculateTotalPrice(orders, paymentMethod);
        
        // 주문 정보 기록 -> OrderBook
        String orderUuid = orderBook.addOrder(orders);
        
        // 음료 제조 요청 -> Barista
        barista.makeBeveragesTo(orderUuid, orderBook);
        
        // 매출 등록 -> Cafe
        cafe.plusSales(price);
        
        return orderUuid;
    }
    
    public String completeOrder(String orderUuid, String message) {
        orderBook.remove(orderUuid);
        return message;
    }
}
