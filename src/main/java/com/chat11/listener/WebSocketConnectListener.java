package com.chat11.listener;

import com.chat11.sevice.OnlineService;
import com.chat11.user.UsersLogin;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketConnectListener {
    private final UsersLogin usersLogin;
    private final SimpMessageSendingOperations messagingTemplate;
    private final OnlineService onlineService;

}