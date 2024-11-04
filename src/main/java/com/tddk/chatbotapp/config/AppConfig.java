package com.tddk.chatbotapp.config;

import com.tddk.chatbotapp.entity.ChatResponse;
import com.tddk.chatbotapp.entity.UserCredential;
import com.tddk.chatbotapp.enums.UserRole;
import com.tddk.chatbotapp.repo.ChatResponseRepo;
import com.tddk.chatbotapp.repo.UserCredentialRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class AppConfig implements CommandLineRunner {
    private final UserCredentialRepo userRepo;
    private final PasswordEncoder encoder;
    private final ChatResponseRepo chatRepo;
    private static final String adminUsername = "admin";
    private static final String adminPassword = "password";
    private static final List<ChatResponse> resList = List.of(
            ChatResponse.builder()
                    .keyword("hello")
                    .response("Hi there! How can I assist you today?")
                    .build(),
            ChatResponse.builder()
                    .keyword("tell me about yourself")
                    .response("I'm your friendly chatbot, here to help with any questions you may have!")
                    .build(),
            ChatResponse.builder()
                    .keyword("what's the weather like today?")
                    .response("Sorry, I currently can't check the weather. Please try using a weather app!")
                    .build(),
            ChatResponse.builder()
                    .keyword("help me calculate")
                    .response("What would you like to calculate? I can assist with basic calculations")
                    .build(),
            ChatResponse.builder()
                    .keyword("goodbye")
                    .response("Goodbye! Hope to chat with you again soon!")
                    .build(),
            ChatResponse.builder()
                    .keyword("thank you")
                    .response("You're welcome! Happy to help.")
                    .build(),
            ChatResponse.builder()
                    .keyword("how to use")
                    .response("Which feature would you like help with? Let me guide you.")
                    .build()
            );

    @Override
    public void run(String... args) throws Exception {
        UserCredential admin = UserCredential.builder()
                .username(adminUsername)
                .password(encoder.encode(adminPassword))
                .roles(List.of(UserRole.ADMIN.name(), UserRole.USER.name()))
                .isAccNonLocked(true)
                .isAccNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build();
        log.warn("Admin created, please change password");

        UserCredential user1 = UserCredential.builder()
                .username("john")
                .password(encoder.encode("password"))
                .fullName("john doe")
                .roles(List.of(UserRole.USER.name()))
                .isAccNonLocked(true)
                .isAccNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build();
        log.info(String.format("User1 created: %s", user1.toString()));

        UserCredential user2 = UserCredential.builder()
                .username("sam")
                .password(encoder.encode("password"))
                .fullName("sam smith")
                .roles(List.of(UserRole.USER.name()))
                .isAccNonLocked(true)
                .isAccNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .build();
        log.info(String.format("User2 created: %s", user2.toString()));
        userRepo.saveAll(List.of(admin, user1, user2));
        chatRepo.saveAll(resList);
    }
}