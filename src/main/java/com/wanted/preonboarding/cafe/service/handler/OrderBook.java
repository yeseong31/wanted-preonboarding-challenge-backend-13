package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;

public class OrderBook {
    
    private static final HashMap<String, Order> orderForms = new HashMap<>();

    public String addOrder(Map<Beverage, Integer> receivedOrders){
    
        String orderUuid = createUUID();
        Order order = Order.createOrder(receivedOrders);
        orderForms.put(orderUuid, order);
        
        return orderUuid;
    }
    public void remove(String orderUuid){
        orderForms.remove(orderUuid);
    }

    public Order getOrder(String orderUuid){
        return orderForms.get(orderUuid);
    }
    
    private String createUUID() {
        return UUID.randomUUID().toString();
    }
}
