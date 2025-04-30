package com.chat11.controller;

import com.chat11.entity.User;
import com.chat11.sevice.LoadOnlineService;
import com.chat11.user.UserDetailsCustom;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final LoadOnlineService loadOnlineService;
    @GetMapping("/login")
    public String login(Authentication authentication , HttpServletRequest request) {
        return "login";
    }
    @GetMapping("/home")
    public String home(Authentication authentication , HttpServletRequest request) {
        loadOnlineService.handleWebSocketConnectListener();
        return "home";

    }
}
