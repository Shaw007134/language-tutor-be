package com.zsy.language_tutor.aspect;

import com.zsy.language_tutor.message.OperationLogProducer;
import com.zsy.language_tutor.model.OperationLog;
import com.zsy.language_tutor.annotation.OperationLogAnnotation;  // Import the OperationLogAnnotation
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Resource
    private OperationLogProducer kafkaProducerService;

    @Around("@annotation(operationLogAnnotation)")  // Reference the annotation
    public Object logOperation(ProceedingJoinPoint joinPoint, OperationLogAnnotation operationLogAnnotation) throws Throwable {
        // Create a new OperationLog object
        OperationLog operationLog = new OperationLog();
        operationLog.setOperation(operationLogAnnotation.value());
        operationLog.setOperator("system");
        operationLog.setOperationTime(new Date());

        // Execute the original method
        Object retVal = joinPoint.proceed();

        // Update the operationLog details with method arguments and return value
        operationLog.setDetails("Request: " + Arrays.toString(joinPoint.getArgs()) + ", Response: " + retVal);
        log.info("operationLog: {}", operationLog);
        // Send the operationLog message to Kafka
        kafkaProducerService.sendMessage("operation-log", operationLog);

        // Return the original method's return value
        return retVal;
    }
}
