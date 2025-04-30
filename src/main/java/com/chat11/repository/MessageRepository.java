package com.chat11.repository;

import com.chat11.entity.Message;
import com.chat11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findBySenderAndReceiver(User sender, User receiver);

    List<Message> findBySenderUsernameAndReceiverUsername(String sender, String receiver);
}
