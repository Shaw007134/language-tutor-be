package com.zsy.language_tutor.service;

import com.zsy.language_tutor.request.SpeakingTaskQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zsy.language_tutor.model.SpeakingTask;
import mapper.SpeakingTaskMapper;

import java.util.Date;
import java.util.List;

@Service
public class SpeakingTaskServiceImpl implements SpeakingTaskService{

    @Resource
    private SpeakingTaskMapper speakingTaskMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return speakingTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SpeakingTask record) {
        Date now = new Date();
        record.setCreatedAt(now);
        record.setUpdatedAt(now);
        return speakingTaskMapper.insert(record);
    }

    @Override
    public int insertSelective(SpeakingTask record) {
        Date now = new Date();
        record.setCreatedAt(now);
        record.setUpdatedAt(now);
        return speakingTaskMapper.insertSelective(record);
    }

    @Override
    public SpeakingTask selectByPrimaryKey(Integer id) {
        return speakingTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SpeakingTask> getQuestions(SpeakingTaskQuery query) {
        return speakingTaskMapper.getQuestions(query);
    }

    @Override
    public int updateByPrimaryKeySelective(SpeakingTask record) {
        record.setUpdatedAt(new Date());
        return speakingTaskMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SpeakingTask record) {
        return speakingTaskMapper.updateByPrimaryKey(record);
    }

    @Override
    public int countSpeakingTasks(SpeakingTaskQuery request) {
        return speakingTaskMapper.countSpeakingTasks(request);
    }

}
