package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.ChatReq;
import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.dto.res.ChatRes;
import com.tddk.chatbotapp.exception.ErrorRes;
import com.tddk.chatbotapp.service.impl.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @Operation(summary = "User send chat request")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sent chat request successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRes.class))
                    }),
                    @ApiResponse(responseCode = "400-599", description = "Sent failed", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRes.class))
                    }),
            }
    )
    @PostMapping("/chat")
    public ResponseEntity<ApiRes<ChatRes>> chat(@RequestBody @Valid ChatReq req) {
        return ResponseEntity.ok().body(
                ApiRes.<ChatRes>builder()
                        .data(chatService.chat(req))
                        .code(HttpStatus.OK.value())
                        .build());
    }
}
