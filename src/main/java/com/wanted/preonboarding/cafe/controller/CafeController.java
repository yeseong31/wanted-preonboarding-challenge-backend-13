package com.wanted.preonboarding.cafe.controller;

import static org.springframework.http.HttpStatus.OK;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import com.wanted.preonboarding.cafe.service.handler.discount.DiscountPolicy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    
    private final CafeService cafeService;
    
    @GetMapping("/hello")
    public ResponseEntity<String> welcomeMessage() {
        
        log.info("CafeController.welcomeMessage()");
        
        final String response = "Welcome to The Wanted coding cafe!!";
        return new ResponseEntity<>(response, OK);
    }
    
    @GetMapping("/order")
    public ResponseEntity<String> orderFromMenu(@RequestBody Customer customer) {
        
        log.info("CafeController.orderFromMenu()");
        
        final String response = cafeService.orderFrom(customer);
        return new ResponseEntity<>(response, OK);
    }
}
