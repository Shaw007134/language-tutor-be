package com.zsy.language_tutor.request;

import com.zsy.language_tutor.dto.request.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakingTaskQuery extends PageRequest {
    private Integer taskType;
    private String title;
    private String content;

}
