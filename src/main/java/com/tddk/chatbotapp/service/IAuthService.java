package com.tddk.chatbotapp.service;


import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.res.TokenRes;

public interface IAuthService {
    TokenRes login(AuthReq req);
}
