package com.panel.messaging;

import com.panel.messaging.model.Message;
import com.panel.messaging.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageResource {
    private final MessageService messageService;

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessage () {
        List<Message> messages = messageService.findAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message){
    	Message newMessage = messageService.addMessage(message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message){
    	Message updateMessage = messageService.updateMessage(message);
        return new ResponseEntity<>(updateMessage, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable("id") Integer id){
    	messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
