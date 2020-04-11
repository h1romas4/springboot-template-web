package com.example.domain;

import org.seasar.doma.Domain;

@Domain(valueType = String.class, factoryMethod = "of")
public enum JobType {
    SALESMAN("10"),
    MANAGER("20"),
    ANALYST("30"),
    PRESIDENT("40"),
    CLERK("50");

    private final String value;

    private JobType(String value) {
        this.value = value;
    }

    public static JobType of(String value) {
        for (JobType jobType : JobType.values()) {
            if (jobType.value.equals(value)) {
                return jobType;
            }
        }
        throw new IllegalArgumentException(value);
    }

    public String getValue() {
        return value;
    }
}
