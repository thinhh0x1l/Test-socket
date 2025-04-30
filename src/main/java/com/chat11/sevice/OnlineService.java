package com.chat11.sevice;

import com.chat11.user.UserDetailsCustom;
import com.chat11.user.UsersLogin;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OnlineService {
    private final UsersLogin usersLogin;

    public void check(UserDetailsCustom userDetailsCustom, HttpSession session) {
        var map = usersLogin.getAccountOnline();
        if(!map.containsKey(userDetailsCustom.getUsername())) {
            map.put(userDetailsCustom.getUsername(), session);
        }else if(map.get(userDetailsCustom.getUsername()) != session) {
            map.get(userDetailsCustom.getUsername()).invalidate();
            map.put(userDetailsCustom.getUsername(), session);
        }else{
            map.get(userDetailsCustom.getUsername()).invalidate();
            map.remove(userDetailsCustom.getUsername());
        }
    }
    public List<String > getOnlineUsers(){
        return new ArrayList<>(usersLogin.getAccountOnline().keySet());
    }

}
