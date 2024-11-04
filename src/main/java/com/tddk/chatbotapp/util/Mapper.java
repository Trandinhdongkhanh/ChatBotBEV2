package com.tddk.chatbotapp.util;

import com.tddk.chatbotapp.dto.res.ChatRes;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.entity.ChatResponse;
import com.tddk.chatbotapp.entity.UserCredential;

public class Mapper {
    public static UserRes toUserRes(UserCredential user) {
        return UserRes.builder()
                .username(user.getUsername())
                .fullName(user.getFullName())
                .build();
    }
    public static ChatRes toChatRes(ChatResponse res){
        return ChatRes.builder()
                .res(res.getResponse())
                .build();
    }
}
