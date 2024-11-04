package com.tddk.chatbotapp.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpReq {
    @NotBlank(message = "Username may not be blank")
    @Size(min = 1)
    private String username;
    @NotBlank(message = "Password may not be blank")
    @Size(min = 1)
    private String password;
    @JsonProperty("full_name")
    @NotBlank(message = "Full name may not be blank")
    @Size(min = 1)
    private String fullName;
}
