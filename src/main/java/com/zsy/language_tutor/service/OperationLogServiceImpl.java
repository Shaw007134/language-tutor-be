package com.zsy.language_tutor.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import mapper.OperationLogMapper;
import com.zsy.language_tutor.model.OperationLog;

@Service
public class OperationLogServiceImpl implements OperationLogService{

    @Resource
    private OperationLogMapper operationLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return operationLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OperationLog record) {
        return operationLogMapper.insert(record);
    }

    @Override
    public int insertSelective(OperationLog record) {
        return operationLogMapper.insertSelective(record);
    }

    @Override
    public OperationLog selectByPrimaryKey(Integer id) {
        return operationLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OperationLog record) {
        return operationLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OperationLog record) {
        return operationLogMapper.updateByPrimaryKey(record);
    }

}
