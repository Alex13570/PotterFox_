package ru.loonolud.potterfox.controller.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Information about unexpected situation
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorInfo {

    private String error;

    private Integer status;

    private String exceptionName;

    private String path;

    private Instant timestamp;
}
