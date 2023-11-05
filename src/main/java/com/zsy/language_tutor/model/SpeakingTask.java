package com.zsy.language_tutor.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakingTask {
    private Integer id;
    private Integer taskType;
    private String title;
    private String content;
    private Integer preparationTime;
    private Integer selectionTime;
    private Integer recordingTime;
    private String images;
    private String descs;
    private String audio;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;
}