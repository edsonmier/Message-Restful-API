package com.coe.chat.service;

import com.chat.producer.model.ChatDTO;
import com.coe.chat.entity.Chat;
import com.coe.chat.repository.ChatRepository;
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

    @KafkaListener(topics = "chat-save-topic", groupId = "group-json")
    public void saveCustomer(ConsumerRecord<Long, ChatDTO> record) throws IOException {
        ChatDTO chat = record.value();
        chat.setCreate_date(new Date());
        Chat entity = new Chat(chat);
        chatRepository.save(entity);
    }

    @KafkaListener(topics = "chat-delete-topic", groupId = "group-json")
    public void deleteCustomer(ConsumerRecord<Long, Integer> record) throws IOException {
        chatRepository.deleteById(record.value());
    }
}
