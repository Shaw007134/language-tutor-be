package com.zsy.language_tutor.exception;

import com.zsy.language_tutor.dto.response.APIResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APIResponse<String> handleException(Exception e) {
        return APIResponse.getErrorResult(e.getMessage());
    }
}

