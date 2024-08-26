package com.harshitksinghai.Chat_WebApp_SpringBoot_Websockets.Controller;

import com.harshitksinghai.Chat_WebApp_SpringBoot_Websockets.DTO.ChatMessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    // url will invoke sendMessage method
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public") // tells which queue to send to // here send to /topic/public
    public ChatMessageDTO sendMessage(@Payload ChatMessageDTO chatMessageDTO){ // everytime we receive a payload, it will be queued to /topic/public
        return chatMessageDTO;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageDTO addUser(@Payload ChatMessageDTO chatMessageDTO, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", chatMessageDTO.getSender()); // add username in websocket session
        return chatMessageDTO;
    }
}
