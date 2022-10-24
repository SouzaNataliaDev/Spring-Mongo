package com.natalia.Blog.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MethodArgumentNotValidExceptionDetails {


    private String title;
    private String message;
    private String fields;
    private String fieldsMessage;
    private LocalDateTime timeStamp;
}
