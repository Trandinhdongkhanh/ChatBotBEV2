package com.tddk.chatbotapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "chat_response")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String keyword;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String response;
}