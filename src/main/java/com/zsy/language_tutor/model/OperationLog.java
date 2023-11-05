package com.zsy.language_tutor.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationLog {
    private Integer id;

    private String operation;

    private String operator;

    private Date operationTime;

    private String details;
}