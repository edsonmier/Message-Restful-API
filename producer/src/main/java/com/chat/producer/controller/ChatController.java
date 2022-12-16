package com.chat.producer.controller;

import com.chat.producer.model.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chat/produce")
@CrossOrigin
public class ChatController {
    @Autowired
    private KafkaTemplate<String, ChatDTO> kafkaChatTemplate;

    @Autowired
    private KafkaTemplate<String, Integer> kafkaRemoveTemplate;

    @PostMapping("")
    public String saveChat(@RequestBody ChatDTO chatDTO){
        kafkaChatTemplate.send("chat-save-topic", chatDTO);
        return "Chat saved successfully.";
    }

    @DeleteMapping("/{idChat}")
    public String deleteChat(@PathVariable("idChat") int idChat){
        kafkaRemoveTemplate.send("chat-delete-topic", idChat);
        return "Chat deleted successfully.";
    }
}
