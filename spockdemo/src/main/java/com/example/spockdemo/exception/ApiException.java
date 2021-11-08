package com.example.spockdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-08 21:45
 */
@Data
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
}
