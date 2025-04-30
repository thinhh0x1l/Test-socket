package com.chat11.controller;

import com.chat11.sevice.OnlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final OnlineService onlineService;



    // Gửi danh sách người dùng online tới client khi có thay đổi
    @SendTo("/topic/online-users")
    public void sendOnlineUsers() {
        List<String> onlineUsers = onlineService.getOnlineUsers();
        messagingTemplate.convertAndSend("/topic/online-users", onlineUsers);
    }
}