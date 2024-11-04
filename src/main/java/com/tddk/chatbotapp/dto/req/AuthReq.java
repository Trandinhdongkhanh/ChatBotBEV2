package com.tddk.chatbotapp.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthReq {
    @NotBlank(message = "Username may not be blank")
    private String username;
    @NotBlank(message = "Password may not be blank")
    private String password;
}
