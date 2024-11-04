package com.tddk.chatbotapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRes> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            sb.append(fieldName).append(": ").append(errorMessage).append("\n");
        });
        return ResponseEntity
                .badRequest()
                .body(ErrorRes.builder()
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST)
                        .message(sb.toString())
                        .build());
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity<ErrorRes> handleStorageException(StorageException ex) {
        log.error("Storage Exception", ex);
        return ResponseEntity.badRequest().body(
                ErrorRes.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorRes> handleBadCredentialsException(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ErrorRes.builder()
                        .status(HttpStatus.UNAUTHORIZED)
                        .code(HttpStatus.UNAUTHORIZED.value())
                        .message(ex.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRes> handleServerError(Exception ex) {
        return ResponseEntity.internalServerError().body(
                ErrorRes.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .build()
        );
    }
}
