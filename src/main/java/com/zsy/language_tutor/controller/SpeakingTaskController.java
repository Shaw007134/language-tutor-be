package com.zsy.language_tutor.controller;

import com.zsy.language_tutor.annotation.OperationLogAnnotation;
import com.zsy.language_tutor.dto.response.APIResponse;
import com.zsy.language_tutor.dto.response.SearchResult;
import com.zsy.language_tutor.dto.request.SpeakingTaskRequest;
import com.zsy.language_tutor.dto.response.TaskTypeResponse;
import com.zsy.language_tutor.enums.SpeakingTaskType;
import com.zsy.language_tutor.request.SpeakingTaskQuery;
import com.zsy.language_tutor.utils.BeanUtil;
import com.zsy.language_tutor.validation.OnCreate;
import com.zsy.language_tutor.validation.OnUpdate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.zsy.language_tutor.model.SpeakingTask;
import com.zsy.language_tutor.service.SpeakingTaskService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/speakingTasks")
public class SpeakingTaskController {

    @Resource
    private SpeakingTaskService speakingTaskService;

    @GetMapping("/taskTypes")
    public List<TaskTypeResponse> getTaskTypes() {
        return Arrays.stream(SpeakingTaskType.values())
                .map(type -> new TaskTypeResponse(type.getValue(), type.getDescription()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public APIResponse<SpeakingTask> getSpeakingTask(@PathVariable Integer id) {
        SpeakingTask task = speakingTaskService.selectByPrimaryKey(id);
        return APIResponse.getOKResult(task);
    }

    @PostMapping("/query")
    public SearchResult<SpeakingTask> querySpeakingTasks(@RequestBody SpeakingTaskQuery request) {
        log.info("querySpeakingTasks request: {}", request);
        List<SpeakingTask> tasks = speakingTaskService.getQuestions(request);
        int total = speakingTaskService.countSpeakingTasks(request);
        SearchResult<SpeakingTask> response = new SearchResult<>();
        response.setData(tasks);
        response.setTotal(total);
        log.info("total task: {}", total);
        return response;
    }

    @OperationLogAnnotation(value = "Create Speaking Task")
    @PostMapping("/create")
    public APIResponse<Integer> createSpeakingTask(@RequestBody @Validated(OnCreate.class) SpeakingTaskRequest request) {
        log.info("createSpeakingTask request: {}", request);
        SpeakingTask speakingTask = BeanUtil.fastCopy(request, SpeakingTask.class);
        int result = speakingTaskService.insert(speakingTask);
        return APIResponse.getOKResult(result);
    }

    @OperationLogAnnotation(value = "Update Speaking Task")
    @PostMapping("/update")
    public APIResponse<Integer> updateSpeakingTask(@RequestBody @Validated(OnUpdate.class) SpeakingTaskRequest request) {
        log.info("updateSpeakingTask request: {}", request);
        SpeakingTask speakingTask = BeanUtil.fastCopy(request, SpeakingTask.class);
        int result = speakingTaskService.updateByPrimaryKeySelective(speakingTask);
        return APIResponse.getOKResult(result);
    }

    @OperationLogAnnotation(value = "Delete Speaking Task")
    @DeleteMapping("/{id}")
    public APIResponse<Integer> deleteSpeakingTask(@PathVariable Integer id) {
        int result = speakingTaskService.deleteByPrimaryKey(id);
        return APIResponse.getOKResult(result);
    }
}
