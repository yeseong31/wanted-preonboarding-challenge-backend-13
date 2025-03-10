package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.Ticket;
import com.wanted.preonboarding.theater.service.handler.TicketOffice;
import com.wanted.preonboarding.theater.service.handler.TicketSeller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterService {
    
    private final Theater theater;
    
    public String enter(AudienceRequestDto requestDto) {
        
        // 관객
        Audience audience = Audience.of(requestDto);
        
        // 판매 중인 티켓
        Ticket ticket = Ticket.builder().fee(100L).build();
        
        // 티켓 판매소
        TicketOffice ticketOffice = new TicketOffice(20000L, ticket);
        
        // 티켓 판매자
        TicketSeller ticketSeller = TicketSeller.builder()
                .ticketOffice(ticketOffice)
                .build();
        
        // 소극장에 입장
        theater.enter(audience, ticketSeller);
        return "Have a good time.";
    }
}
