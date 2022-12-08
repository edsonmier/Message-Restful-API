package com.chat.producer.controller;

import com.chat.producer.model.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chat-options")
public class ChatController {
    @Autowired
    private KafkaTemplate<String, ChatDTO> kafkaChatTemplate;

    @Autowired
    private KafkaTemplate<String, Integer> kafkaRemoveTemplate;

    @GetMapping("/produce/{name}")
    public String myMessage(@PathVariable("name") final String name){
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setName(name);
        kafkaChatTemplate.send("chatEntity", chatDTO);
        return "Message Published Successfully";
    }

    @PostMapping("/chat_save/{name}")
    public String saveMyChat(@PathVariable("name") final String name){
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setName(name);
        kafkaChatTemplate.send("chat_save", chatDTO);
        return "Ya se hizo el guiso";
    }

    @DeleteMapping("/chat_delete/{id}")
    public String deleteMyChat(@PathVariable("id") int id){
        kafkaRemoveTemplate.send("chat_delete", id);
        return "Ya se borro el guiso";
    }
}
