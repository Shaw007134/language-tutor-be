package com.zsy.language_tutor.enums;

public enum SpeakingTaskType {
    TASK_1(1, "Task 1"),
    TASK_2(2, "Task 2"),
    TASK_3(3, "Task 3"),
    TASK_4(4, "Task 4"),
    TASK_5(5, "Task 5"),
    TASK_6(6, "Task 6"),
    TASK_7(7, "Task 7"),
    TASK_8(8, "Task 8");

    private final int value;
    private final String description;

    SpeakingTaskType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }

    public static SpeakingTaskType fromValue(int value) {
        for (SpeakingTaskType taskType : SpeakingTaskType.values()) {
            if (taskType.getValue() == value) {
                return taskType;
            }
        }
        throw new IllegalArgumentException("Unknown TaskType value: " + value);
    }
}
