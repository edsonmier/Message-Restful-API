package com.coe.chat.controller;

import com.coe.chat.entity.Chat;
import com.chat.producer.model.ChatDTO;
import com.coe.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

