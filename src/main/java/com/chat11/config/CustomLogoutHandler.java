package com.chat11.config;

import com.chat11.controller.WebSocketController;
import com.chat11.sevice.OnlineService;
import com.chat11.user.UserDetailsCustom;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomLogoutHandler implements LogoutHandler {
    private final WebSocketController webSocketController;
    private final OnlineService onlineService;
    private final SimpMessageSendingOperations messagingTemplate;
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("aloo");
        System.out.println(authentication.getName());
        onlineService.check((UserDetailsCustom) authentication.getPrincipal(),request.getSession(false));
        messagingTemplate.convertAndSend("/topic/online-users", onlineService.getOnlineUsers());
    }
}
