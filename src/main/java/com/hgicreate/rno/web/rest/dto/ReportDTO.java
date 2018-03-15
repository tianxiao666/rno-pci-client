package com.hgicreate.rno.web.rest.dto;

import lombok.Data;

/**
 * 报告
 *
 * @author li.tf
 * @date 2018-01-12 14:44:39
 */
@Data
public class ReportDTO {

    private String stage;
    private String startTime;
    private String endTime;
    private String result;
    private String detail;

}
