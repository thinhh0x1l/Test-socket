package com.chat11.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Service
@RequiredArgsConstructor
public class LoadOnlineService {
    private final SimpMessageSendingOperations messagingTemplate;
    private final OnlineService onlineService;
    private int time = 500;
    public void handleWebSocketConnectListener() {
        System.out.println("111");
        System.out.println("Sending online users: " + onlineService.getOnlineUsers());
        new Thread(() -> {
            try {
                Thread.sleep(time); // Đợi 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            messagingTemplate.convertAndSend("/topic/online-users", onlineService.getOnlineUsers());
        }).start();
    }
}
