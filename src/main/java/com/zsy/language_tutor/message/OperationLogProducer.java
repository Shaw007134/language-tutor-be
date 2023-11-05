package com.zsy.language_tutor.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsy.language_tutor.model.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OperationLogProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(String topic, OperationLog operationLog) {
        try {
            String message = objectMapper.writeValueAsString(operationLog);
            kafkaTemplate.send(topic, message);
        } catch (Exception e) {
            log.error("send message error", e);
        }
    }
}
