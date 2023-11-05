package com.zsy.language_tutor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {
    private int code;
    private String message;
    private String error;
    private T data;

    public static <T> APIResponse<T> getOKResult(T data) {
        APIResponse<T> response = new APIResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setData(data);
        return response;
    }

    public static <T> APIResponse<T> getErrorResult(String message) {
        APIResponse<T> response = new APIResponse<>();
        response.setCode(400);
        response.setError(message);
        return response;
    }
}
