package com.tddk.chatbotapp.service;


import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ChatRes;

public interface IChatService {
    ChatRes chat(ChatReq req);
}
