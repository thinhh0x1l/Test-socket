package com.chat11.controller;

import com.chat11.dto.request.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;
import java.time.LocalDateTime;

//@Controller
//@RequiredArgsConstructor
//public class ChatWebSocketController {
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @MessageMapping("/chat")
//    @EventListener
//    public void sendMessage(ChatMessage message, Principal principal, SessionDisconnectEvent) {
//        // Bạn có thể lưu vào DB tại đây nếu muốn
//
//        message.setTimestamp(LocalDateTime.now().toString());
//        message.setSender(principal.getName());
//
//        // Gửi cho người nhận theo queue riêng của họ
//        messagingTemplate.convertAndSendToUser(
//                message.getReceiver(),
//                "/queue/messages",
//                message
//        );
//    }
//}
