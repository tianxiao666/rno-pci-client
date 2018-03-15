package com.hgicreate.rno.service.dto;

import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chen.c10
 */
@Data
public class JobDTO implements Serializable {
    private Long id;
    private String name;
    private JobType type;
    private String description;
    private Long areaCode;
    private String areaName;
    private JobStatus runningStatus;
    private String finishState;
    private LocalDateTime launchTime, completeTime;

    private List<JobParamDTO> params;
}
