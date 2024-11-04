package com.tddk.chatbotapp.dto.res;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiRes<T> {
    private int code;
    private T data;
}
