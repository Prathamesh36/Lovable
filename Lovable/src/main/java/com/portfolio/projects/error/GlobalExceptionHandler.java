package com.portfolio.projects.error;

import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Method;
import java.rmi.AccessException;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException exception){
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage());
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleBadRequest(ResourceNotFoundException exception){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getResourceName() + " with id "+ exception.getResourceId()+ " not found");
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInputValidationError(MethodArgumentNotValidException exception){
        List<ApiFieldError> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiFieldError(error.getField(), error.getDefaultMessage()))
                .toList();

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Input validation Failed", errors);
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(UsernameNotFoundException exception){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Username not found with username: "+exception.getMessage());
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException exception){
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "Authentication failed: "+exception.getMessage());
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleJwtException(JwtException exception){
        ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, "Invalid JWT token: "+exception.getMessage());
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(AccessException.class)
    public ResponseEntity<ApiError> handleAccessDeniedException(AccessException exception){
        ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, "Access denied: Insufficient permissions");
        log.error(apiError.toString(), exception);
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

}
