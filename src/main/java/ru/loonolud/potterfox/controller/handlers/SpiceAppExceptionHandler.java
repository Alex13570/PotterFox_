package ru.loonolud.potterfox.controller.handlers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.loonolud.potterfox.exceptions.PotterFoxException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class SpiceAppExceptionHandler {

    private final static String ERROR_VALID_MESSAGE = "Validation error";

    @ExceptionHandler(value = PotterFoxException.class)
    public ResponseEntity<Object> handleSpException(PotterFoxException e, HttpServletRequest request) {
        log.warn("Got exception " + e.getMessage() + " (status " + e.getHttpStatus() + ") " +
                "from URL " + request.getRequestURI());
        return getError(e, request);
    }

    @ExceptionHandler(value = SizeLimitExceededException.class)
    public ResponseEntity<Object> handleSpException(SizeLimitExceededException e, HttpServletRequest request) {
        log.warn("Got exception " + e.getMessage() + " (status 400) " +
                "from URL " + request.getRequestURI());
        return getOtherError(e, request);
    }

    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<Object> handleSpException(InvalidFormatException e, HttpServletRequest request) {
        log.warn("Got exception " + e.getMessage() + " (status 400) " +
                "from URL " + request.getRequestURI());
        return getOtherError(e, request);
    }

    private ResponseEntity<Object> getOtherError(Exception e, HttpServletRequest request) {
        return new ResponseEntity<>(ErrorInfo.builder()
                .timestamp(Instant.now())
                .error(e.getMessage())
                .status(400)
                .exceptionName(e.getClass().getSimpleName())
                .path(request.getRequestURI())
                .build(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> getError(PotterFoxException e, HttpServletRequest request) {
        return new ResponseEntity<>(ErrorInfo.builder()
                .timestamp(Instant.now())
                .error(e.getMessage())
                .status(e.getHttpStatus().value())
                .exceptionName(e.getClass().getSimpleName())
                .path(request.getRequestURI())
                .build(), e.getHttpStatus());
    }


    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorValidInfo> handleValidException(BindException e, HttpServletRequest request) {

        log.warn(String.format("Got validation exception %s from URL %s", e.getMessage(), request.getRequestURI()));

        ErrorValidInfo errorValidDto = ErrorValidInfo.builder()
                .code(HttpStatus.BAD_REQUEST)
                .message(ERROR_VALID_MESSAGE)
                .validErrors(processFieldErrors(e.getBindingResult()))
                .path(request.getRequestURI())
                .exceptionName(e.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(errorValidDto, errorValidDto.getCode());
    }

    private List<ValidError> processFieldErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map( e -> {
                    if (e instanceof FieldError) {
                        FieldError error = (FieldError) e;
                        return new ValidError(error.getField(),error.getDefaultMessage());
                    }
                    return new ValidError(e.getObjectName(), e.getDefaultMessage());
                })
                .collect(Collectors.toList());

    }
}
