package com.hgicreate.rno.web.rest.vm;

import com.hgicreate.rno.model.JobType;
import lombok.Data;

/**
 * 任务查询信息
 *
 * @author li.tf
 * @date 2018-01-12 14:48:49
 */
@Data
public class JobQueryVm {

    private String account;
    private JobType jobType;
    private Long cityId;
    private String taskName;
    private String taskStatus;
    private String startSubmitTime;
    private String endSubmitTime;

}
