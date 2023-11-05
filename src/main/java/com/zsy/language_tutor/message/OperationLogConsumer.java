package com.zsy.language_tutor.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsy.language_tutor.model.OperationLog;
import com.zsy.language_tutor.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OperationLogConsumer {

    @Resource
    private OperationLogService operationLogService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "operation-log", groupId = "operation-log-group")
    public void listen(String message) {
        try {
            OperationLog operationLog = objectMapper.readValue(message, OperationLog.class);
            operationLogService.insert(operationLog);
        } catch (Exception e) {
            log.error("receive message error", e);
        }
    }
}
