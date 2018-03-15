package com.hgicreate.rno.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 天线方位角作业dto对象
 *
 * @author li.tf
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AzimuthEvaluationTaskDTO extends AbstractTaskDTO {
    private String cityName;
    private Long jobId;
    private String jobName;
    private String jobRunningStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime launchTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completeTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String begMeaTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String endMeaTime;
}
