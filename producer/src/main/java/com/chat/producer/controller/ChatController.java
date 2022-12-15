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

    //Antiguo
    @PostMapping("/chat_save/{name}")
    public String saveMyChat(@PathVariable("name") final String name){
        ChatDTO chatDTO = new ChatDTO();
        kafkaChatTemplate.send("chat_save", chatDTO);
        return "Chat saved succesfully.";
    }

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

    //Antiguo
    @DeleteMapping("/chat_delete/{id}")
    public String deleteMyChat(@PathVariable("id") int id){
        kafkaRemoveTemplate.send("chat_delete", id);
        return "Chat deleted succesfully.";
    }
}
