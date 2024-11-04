package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ChatRes;
import com.tddk.chatbotapp.entity.ChatResponse;
import com.tddk.chatbotapp.repo.ChatResponseRepo;
import com.tddk.chatbotapp.service.IChatService;
import com.tddk.chatbotapp.util.RandomList;
import com.tddk.chatbotapp.util.TextJustification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService implements IChatService {
    private final ChatResponseRepo chatRepo;

    @Override
    public ChatRes chat(ChatReq req) {
        List<ChatResponse> resList = chatRepo.findByKeyword(TextJustification.justify(req.getQuestion()));
        ChatResponse res = RandomList.random(resList);

        return ChatRes.builder()
                .res(res != null ? res.getResponse() : "Can you please provide me with more information ?")
                .build();
    }
}
