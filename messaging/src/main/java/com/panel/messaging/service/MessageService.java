package com.panel.messaging.service;

import com.panel.messaging.model.Message;
import com.panel.messaging.repo.MessagingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
	
    private final MessagingRepo messagingRepo;

    @Autowired
    public MessageService(MessagingRepo messagingRepo) {
        this.messagingRepo = messagingRepo;
    }

    public Message addMessage(Message message){
        return messagingRepo.save(message);
    }

    public List<Message> findAllMessages(){ return messagingRepo.findAll(); }

    public Message updateMessage(Message message) { return messagingRepo.save(message); }

    public void deleteMessage(int id){
        messagingRepo.delete(messagingRepo.getById(id));
    }
}
