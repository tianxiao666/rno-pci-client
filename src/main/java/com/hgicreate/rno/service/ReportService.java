package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Report;
import com.hgicreate.rno.service.dto.ReportDTO;

import java.util.List;

/**
 * 报告服务接口
 *
 * @author chen.c10
 */
public interface ReportService {
    /**
     * 通过ID获取一个报告
     *
     * @param id 报告ID
     * @return 报告
     */
    ReportDTO getReport(long id);

    /**
     * 通过任务ID获取报告列表
     *
     * @param jobId 任务ID
     * @return 报告列表
     */
    List<Report> getReportsByJobId(long jobId);


    /**
     * 通过任务ID获取报告列表
     *
     * @param jobId 任务ID
     * @return 报告列表
     */
    List<ReportDTO> getReportsByJobId2(long jobId);

    /**
     * 保存报告
     *
     * @param report 报告对象
     * @return 报告对象
     */
    Report saveReport(Report report);

    /**
     * 样例查找报告列表
     *
     * @param report 样例报告
     * @return 报告列表
     */
    List<ReportDTO> findAll(Report report);
}
