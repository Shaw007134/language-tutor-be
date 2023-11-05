package com.zsy.language_tutor.service;

import com.zsy.language_tutor.request.SpeakingTaskQuery;
import com.zsy.language_tutor.model.SpeakingTask;

import java.util.List;

public interface SpeakingTaskService{


    int deleteByPrimaryKey(Integer id);

    int insert(SpeakingTask record);

    int insertSelective(SpeakingTask record);

    SpeakingTask selectByPrimaryKey(Integer id);

    List<SpeakingTask> getQuestions(SpeakingTaskQuery query);

    int updateByPrimaryKeySelective(SpeakingTask record);

    int updateByPrimaryKey(SpeakingTask record);

    int countSpeakingTasks(SpeakingTaskQuery request);
}
