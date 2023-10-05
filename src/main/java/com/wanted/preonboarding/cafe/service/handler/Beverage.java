package com.wanted.preonboarding.cafe.service.handler;


import java.util.Map;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Beverage {
    
    private String menuName;  // 메뉴 이름
    private long price;       // 가격
    private Map<String, Long> extraRecipe;  // 추가 레시피
    
    @Builder
    public Beverage(String m, long p, Map<String, Long> r) {
        this.menuName = m;
        this.price = p;
        this.extraRecipe = r;
    }
    
    public long calculatePrice() {
        
        long extraRecipeTotalAmount = 0L;
        
        if (!extraRecipe.isEmpty()) {
            for (String extraMenu : extraRecipe.keySet()) {
                extraRecipeTotalAmount += extraRecipe.get(extraMenu);
            }
        }
        
        return getPrice() + extraRecipeTotalAmount;
    }
}
