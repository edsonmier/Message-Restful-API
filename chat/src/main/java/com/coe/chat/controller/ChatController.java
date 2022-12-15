package com.coe.chat.controller;

import com.coe.chat.entity.Chat;
import com.coe.chat.entity.Customer;
import com.coe.chat.producer.model.ChatDTO;
import com.coe.chat.producer.model.CustomerDTO;
import com.coe.chat.repository.ChatRepository;
import com.coe.chat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/chat")
@CrossOrigin
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/{idChat}")
    public ChatDTO getChatById(@PathVariable("idChat") int idChat) {
        Chat chatEntity = chatRepository.findById(idChat).orElse(null);
        return new ChatDTO(chatEntity);
    }

    @GetMapping("")
    public List<ChatDTO> getChats() {
        List<ChatDTO> chats = new ArrayList<>();
        List<Chat> entities = chatRepository.findAll();
        for (Chat entity : entities) {
            chats.add(new ChatDTO(entity));
        }
        return chats;
    }

    //@GetMapping("/chats/{customerId}")
    //public ChatDTO getChatsByCustomerId(@PathVariable("customerId") int customerId) throws IOException {
        //List<ChatDTO> chats = new ArrayList<>();
        //List<Chat> entities = chatRepository.findAll();
    //}
}
