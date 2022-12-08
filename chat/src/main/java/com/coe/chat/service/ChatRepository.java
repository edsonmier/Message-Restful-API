package com.coe.chat.service;

import com.coe.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {

}
