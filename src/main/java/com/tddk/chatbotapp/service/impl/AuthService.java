package com.tddk.chatbotapp.service.impl;

import com.tddk.chatbotapp.config.security.TokenGenerator;
import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements IAuthService {
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authManager;
    @Override
    public TokenRes login(AuthReq req) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                req.getUsername(), req.getPassword()
        ));
        return tokenGenerator.generateTokens(authentication);
    }
}
