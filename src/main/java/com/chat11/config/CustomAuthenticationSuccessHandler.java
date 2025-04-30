package com.chat11.config;

import com.chat11.controller.WebSocketController;
import com.chat11.sevice.OnlineService;
import com.chat11.user.UserDetailsCustom;
import com.chat11.user.UsersLogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final WebSocketController webSocketController;
    private final OnlineService onlineService;
    private final SimpMessageSendingOperations messagingTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println();
        System.out.println("in onAuthenticationSuccess");
        var session = request.getSession(false);
        System.out.println(session.getId());
        onlineService.check((UserDetailsCustom) authentication.getPrincipal(),request.getSession(false));
        response.sendRedirect("/home");
    }
}
