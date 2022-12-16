package com.coe.chat.service;

import com.chat.producer.model.ChatDTO;
import com.coe.chat.entity.Chat;
import com.coe.chat.repository.ChatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class ChatConsumer {
    @Autowired
    private ChatRepository chatRepository;

    @KafkaListener(topics = "chat", groupId = "group_json")
    public void myConsumerEntity(ConsumerRecord<Long, Chat> record) throws IOException{
        System.out.println("Received Message: \n" + record.value());
    }

    // Antiguo
    @KafkaListener(topics = "chat_save", groupId = "group_json")
    public void saveChat(ConsumerRecord<Long, ChatDTO> record) throws IOException{
        ChatDTO chatDTO = record.value();
        chatDTO.setCreate_date(new Date());
        Chat chatEntity = new Chat(chatDTO);
        System.out.println(parseToJson(chatEntity));
        chatRepository.save(chatEntity);
    }

    @KafkaListener(topics = "chat-save-topic", groupId = "group-json")
    public void saveCustomer(ConsumerRecord<Long, ChatDTO> record) throws IOException {
        System.out.println(record.value());
        ChatDTO chat = record.value();
        chat.setCreate_date(new Date());
        Chat entity = new Chat(chat);
        chatRepository.save(entity);
        System.out.println(entity.toString());
    }

    // Antiguo
    @KafkaListener(topics = "chat_delete", groupId = "group_json")
    public void deleteChat(ConsumerRecord<Long, Integer> record) throws IOException{
        chatRepository.deleteById(record.value());
    }

    @KafkaListener(topics = "chat-delete-topic", groupId = "group-json")
    public void deleteCustomer(ConsumerRecord<Long, Integer> record) throws IOException {
        chatRepository.deleteById(record.value());
    }

    public String parseToJson(Object objectToParse) throws JsonProcessingException {
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(objectToParse);
        result = jsonString;
        return result;
    }

    public void assignJSON(String JsonToAssign) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Object myObject = mapper.readValue(JsonToAssign, Object.class);
    }
}
