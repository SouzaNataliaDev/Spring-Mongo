package com.natalia.Blog.exception;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders httpHeaders,
            HttpStatus httpStatus,
            WebRequest webRequest) {

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        return new ResponseEntity<>(
                MethodArgumentNotValidExceptionDetails.builder()
                        .title("Parâmetros inválidos")
                        .message("Os campos estão inválidos")
                        .fields(errors.stream().map(FieldError::getField)
                                .collect(Collectors.joining("; ")))
                        .fieldsMessage(errors.stream().map(FieldError::getDefaultMessage)
                                .collect(Collectors.joining("; ")))
                        .timeStamp(LocalDateTime.now())
                        .build(), httpStatus);
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ExceptionDetails> handlerClientException(ClientException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Cliente ja cadastrado")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ExceptionDetails> handlerConversionFailedException(ConversionFailedException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Cliente nao encontrado, id nao existe ")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Cliente nao encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

}