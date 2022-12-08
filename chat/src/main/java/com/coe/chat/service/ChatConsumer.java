package com.coe.chat.service;

import com.chat.producer.model.ChatDTO;
import com.coe.chat.entity.Chat;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class ChatConsumer {
    private ChatRepository chatRepository;

    @KafkaListener(topics = "chat", groupId = "group_json")
    public void myConsumerEntity(ConsumerRecord<Long, Chat> record) throws IOException{
        System.out.println("Received Message: \n" + record.value());
    }

    @KafkaListener(topics = "chat_save", groupId = "group_json")
    public void saveChat(ConsumerRecord<Long, ChatDTO> record) throws IOException{
        ChatDTO chatDTO = record.value();
        chatDTO.setCreate_date(new Date());
        Chat chatEntity = new Chat(chatDTO);
        chatRepository.save(chatEntity);
    }
}
