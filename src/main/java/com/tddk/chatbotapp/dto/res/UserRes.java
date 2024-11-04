package com.tddk.chatbotapp.dto.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRes {
    @JsonProperty("full_name")
    private String fullName;
    private String username;
}
