package com.tddk.chatbotapp.service;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.UserRes;

import java.util.List;

public interface IUserCredentialService {
    UserRes signup(SignUpReq req);
    List<UserRes> getUsers();
}
