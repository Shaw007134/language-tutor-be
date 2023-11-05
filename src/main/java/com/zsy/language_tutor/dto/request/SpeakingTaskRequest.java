package com.zsy.language_tutor.dto.request;

import java.util.Date;

import com.zsy.language_tutor.validation.OnCreate;
import com.zsy.language_tutor.validation.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakingTaskRequest {
    @NotNull(groups = OnUpdate.class)
    private Integer id;

    @NotNull(groups = {OnCreate.class})
    @Min(value = 1, groups = {OnCreate.class})
    private Integer taskType;

    @NotBlank(groups = {OnCreate.class})
    @Size(max = 255, groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @NotBlank(groups = {OnCreate.class})
    private String content;

    @NotNull(groups = {OnCreate.class, OnUpdate.class})
    private Integer preparationTime;

    private Integer selectionTime;

    @NotNull(groups = {OnCreate.class})
    private Integer recordingTime;

    @Size(max = 2048, groups = {OnCreate.class, OnUpdate.class})
    private String images;

    @Size(max = 1024, groups = {OnCreate.class, OnUpdate.class})
    private String descs;

    private String audio;

    private Date createdAt;

    private Date updatedAt;
}
