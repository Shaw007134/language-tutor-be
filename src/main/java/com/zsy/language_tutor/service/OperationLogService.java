package com.zsy.language_tutor.service;

import com.zsy.language_tutor.model.OperationLog;
public interface OperationLogService{


    int deleteByPrimaryKey(Integer id);

    int insert(OperationLog record);

    int insertSelective(OperationLog record);

    OperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperationLog record);

    int updateByPrimaryKey(OperationLog record);

}
