package com.wanted.preonboarding.cafe.service.handler;

import static com.wanted.preonboarding.cafe.service.handler.OrderStatus.PENDING;
import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

import jakarta.persistence.Enumerated;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Order {
    
    private Map<Beverage, Integer> orderGroup;  // 음료 정보 및 주문 개수
    
    @Enumerated(STRING)
    private OrderStatus status;  // 0: pending, 1: processing, 2: completed
    
    private Order(Map<Beverage, Integer> orderGroup) {
        this.orderGroup = orderGroup;
    }
    
    public static Order createOrder(Map<Beverage, Integer> orderGroup) {
        
        Order order = new Order(orderGroup);
        order.updateOrder(PENDING);
        return order;
    }
    
    public void changeOrderStatus(OrderStatus orderStatus) {
        updateOrder(orderStatus);
    }
    
    private void updateOrder(OrderStatus status) {
        this.status = status;
    }
}
