package com.chat11.user;

import jakarta.servlet.http.HttpSession;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersLogin {
    Map<String, HttpSession> accountOnline = new ConcurrentHashMap<>();
}
