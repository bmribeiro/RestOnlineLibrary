package com.codelab.restOnlineLibrary.jms;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/send/message")
    @SendTo("/topic/reservations")
    public String sendMessage(String message) {
    	
        return "Processed message: " + message;
    }
}