package com.tddk.chatbotapp.controller;

import com.tddk.chatbotapp.dto.req.SignUpReq;
import com.tddk.chatbotapp.dto.res.ApiRes;
import com.tddk.chatbotapp.dto.res.UserRes;
import com.tddk.chatbotapp.exception.ErrorRes;
import com.tddk.chatbotapp.service.impl.UserCredentialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "User Controller")
public class UserController {
    private final UserCredentialService userService;

    @Operation(summary = "Sign up new user")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Sign up successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRes.class))
                    }),
                    @ApiResponse(responseCode = "400-599", description = "Sign up failed", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRes.class))
                    }),
            }
    )
    @PostMapping("/user")
    public ResponseEntity<ApiRes<?>> signup(@RequestBody @Valid SignUpReq req) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiRes.builder()
                        .code(HttpStatus.CREATED.value())
                        .data(userService.signup(req))
                        .build());
    }

    @Operation(summary = "Get list of users (admin only)")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Get users successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiRes.class))
                    }),
                    @ApiResponse(responseCode = "400-599", description = "Get users failed", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorRes.class))
                    }),
            }
    )
    @GetMapping("/users")
    public ResponseEntity<ApiRes<List<UserRes>>> getUsers() {
        return ResponseEntity.ok(ApiRes.<List<UserRes>>builder()
                .code(HttpStatus.OK.value())
                .data(userService.getUsers())
                .build());

    }
}
