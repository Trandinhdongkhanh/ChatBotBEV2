package com.tddk.chatbotapp.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorRes {
    private int code;
    private HttpStatus status;
    private String message;
}
