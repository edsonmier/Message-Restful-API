package com.coe.chat.service;

import com.chat.producer.model.ChatDTO;
import com.coe.chat.entity.Chat;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ChatConsumer {
    private ChatRepository chatRepository = new ChatRepository() {
        @Override
        public List<Chat> findAll() {
            return null;
        }

        @Override
        public List<Chat> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Chat> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public <S extends Chat> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Chat> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Chat> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Chat> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Chat getOne(Integer integer) {
            return null;
        }

        @Override
        public Chat getById(Integer integer) {
            return null;
        }

        @Override
        public Chat getReferenceById(Integer integer) {
            return null;
        }

        @Override
        public <S extends Chat> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Chat> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Chat> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Chat> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Chat> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Chat entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {

        }

        @Override
        public void deleteAll(Iterable<? extends Chat> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Chat> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Chat> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Chat> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Chat> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Chat, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

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
        System.out.println(chatEntity);
    }
}
