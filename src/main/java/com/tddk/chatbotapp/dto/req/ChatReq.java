package com.tddk.chatbotapp.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatReq {
    @NotBlank(message = "Question may not be blank")
    private String question;
}
