package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.AuthReq;
import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.exception.ErrorRes;
import com.tddk.chatbotapp.service.impl.AuthService;
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
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "User sign in")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Sign in successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRes.class))
                    }),
                    @ApiResponse(responseCode = "400-599", description = "Sign in failed", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRes.class))
                    }),
            }
    )
    @PostMapping("/user/login")
    public ResponseEntity<ApiRes<TokenRes>> login(@RequestBody @Valid AuthReq req) {
        return ResponseEntity.ok().body(
                ApiRes.<TokenRes>builder()
                        .code(HttpStatus.OK.value())
                        .data(authService.login(req))
                        .build());
    }
}
