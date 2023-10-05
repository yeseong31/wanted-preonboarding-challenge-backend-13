package com.wanted.preonboarding.cafe.service.handler;

import static com.wanted.preonboarding.cafe.service.handler.OrderStatus.COMPLETED;
import static com.wanted.preonboarding.cafe.service.handler.OrderStatus.PROCESSING;
import static lombok.AccessLevel.PROTECTED;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Barista {
    
    private int rank;   // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making
    
    @Builder
    public Barista(int rank, int status) {
        this.rank = rank;
        this.status = status;
    }
    
    /**
     * 음료 제조
     */
    public String makeBeveragesTo(String orderUuid, OrderBook orderBook) {
    
        Order order = orderBook.getOrder(orderUuid);
    
        order.changeOrderStatus(PROCESSING);
        
        StringBuilder makeOrders = new StringBuilder();
        makeOrders.append("주문 ID: ")
                .append(orderUuid)
                .append("\n");
        
        order.getOrderGroup().forEach(((beverage, quantity) ->
                makeOrders.append(beverage.getMenuName())
                        .append(":")
                        .append(quantity)));
        
        order.changeOrderStatus(COMPLETED);
        
        return makeOrders.toString();
    }
}
