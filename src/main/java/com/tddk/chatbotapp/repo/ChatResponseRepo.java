package com.tddk.chatbotapp.repo;

import com.tddk.chatbotapp.entity.ChatResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatResponseRepo extends JpaRepository<ChatResponse, Integer> {
    List<ChatResponse> findByKeyword(String keyword);
}
