package com.wanted.preonboarding.cafe.service.handler.discount;

public class MembershipDiscountPolicy implements DiscountPolicy {
    
    private static final long DISCOUNT_AMOUNT = 90;
    
    @Override
    public boolean isSatisfied() {
        return false;
    }
    
    @Override
    public long calculateDiscountAmount() {
        return DISCOUNT_AMOUNT;
    }
}
