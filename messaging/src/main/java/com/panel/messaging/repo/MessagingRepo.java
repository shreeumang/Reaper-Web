package com.panel.messaging.repo;

import com.panel.messaging.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagingRepo extends JpaRepository<Message, Integer> {
}
