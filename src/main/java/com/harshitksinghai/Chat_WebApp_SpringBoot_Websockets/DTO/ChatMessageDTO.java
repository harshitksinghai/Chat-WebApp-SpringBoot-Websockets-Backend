package com.harshitksinghai.Chat_WebApp_SpringBoot_Websockets.DTO;

import com.harshitksinghai.Chat_WebApp_SpringBoot_Websockets.Enums.MessageType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDTO {
    private String content;
    private String sender;
    private MessageType type;
}
