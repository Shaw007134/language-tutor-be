package com.zsy.language_tutor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTypeResponse {
    private int value;
    private String desc;
}
