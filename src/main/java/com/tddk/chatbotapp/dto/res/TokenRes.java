package com.tddk.chatbotapp.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tddk.chatbotapp.enums.TokenType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenRes {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("access_token_expiry")
    private int accessTokenExpiry;
    @JsonProperty("token_type")
    private TokenType tokenType;
}
