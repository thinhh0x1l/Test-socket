package com.chat11.config;

import com.chat11.controller.WebSocketController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionListener implements ApplicationListener<SessionDestroyedEvent> {

    private final WebSocketController webSocketController;

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        // Cập nhật lại danh sách người dùng online khi có người dùng đăng xuất
        webSocketController.sendOnlineUsers();
    }
}
