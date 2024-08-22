package com.codelab.restOnlineLibrary.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.codelab.restOnlineLibrary.dto.ReservationDTO;

@Component
public class ReservationListener {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @JmsListener(destination = "queue.reservation")
    public void onReservaReceived(ReservationDTO reservationDTO) {
    	
        simpMessagingTemplate.convertAndSend("/topic/reservation", reservationDTO);
    }
}