package com.hgicreate.rno.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chen.c10
 */
@Data
public class JobParamDTO implements Serializable {
    private Long id;
    private Long jobId;
    private ParamType type;
    private String code;
    private String value;

    public enum ParamType {
        // 阈值和参数
        THRESHOLD, PROPERTY, TEST
    }
}