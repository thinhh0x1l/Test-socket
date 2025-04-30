package com.chat11;

import com.chat11.entity.Role;
import com.chat11.entity.User;
import com.chat11.repository.RoleRepository;
import com.chat11.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Chat11Application {

    public static void main(String[] args) {
        SpringApplication.run(Chat11Application.class, args);
    }
    @Bean
    ApplicationRunner init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(!roleRepository.existsById("ADMIN"))
                roleRepository.save(new Role("ADMIN"));
            if(!roleRepository.existsById("USER"))
                roleRepository.save(new Role("USER"));
            if(!userRepository.existsByUsername("admin")){
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .build();
                user.addRole(roleRepository.findById("ADMIN").get());
                userRepository.save(user);
            }
            if(!userRepository.existsByUsername("user")){
                User user = User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("user"))
                        .build();
                user.addRole(roleRepository.findById("USER").get());
                userRepository.save(user);
            }
        };
    }
}
