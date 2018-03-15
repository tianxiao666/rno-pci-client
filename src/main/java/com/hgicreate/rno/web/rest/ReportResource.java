package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.model.Report;
import com.hgicreate.rno.service.ReportService;
import com.hgicreate.rno.service.dto.ReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author chen.c10
 */
@Slf4j
@CrossOrigin
@RestController
public class ReportResource {

    private ReportService reportService;

    public ReportResource(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * 通过id获取报告
     */
    @GetMapping("/reports/{id}")
    public ReportDTO getReport(@PathVariable("id") long id) {
        log.debug("进入方法：getReport。id={}", id);
        return reportService.getReport(id);
    }

    /**
     * 通过id获取报告
     */
    @GetMapping("/reports")
    public List<ReportDTO> getReports(Report report) {
        log.debug("进入方法：getReports。report={}", report);
        return reportService.findAll(report);
    }

    /**
     * 通过jobId获取报告
     */
    @GetMapping("/query-report/{jobId}")
    public List<ReportDTO> getReportsByJobId(@PathVariable("jobId") long jobId) {
        log.debug("进入方法：getReportsByJobId。id={}", jobId);
        return reportService.getReportsByJobId2(jobId);
    }

    /**
     * 通过jobId获取报告
     */
    @GetMapping("/reports/find-by-job-id/{jobId}")
    public List<ReportDTO> findByJobId(@PathVariable("jobId") long jobId) {
        log.debug("进入方法：getReportsByJobId。id={}", jobId);
        return reportService.getReportsByJobId2(jobId);
    }

    /**
     * 增加一条新的报告记录
     */
    @PostMapping("/saveReport")
    public Report saveReport(@RequestBody Report report) {
        log.debug("进入方法:saveReport。report = {}", report);
        return reportService.saveReport(report);
    }

    /**
     * 增加一条新的报告记录
     */
    @PostMapping("/reports")
    public ResponseEntity<Report> saveReport2(@RequestBody Report report) throws URISyntaxException {
        log.debug("进入方法:saveReport。report = {}", report);
        if (null == report || report.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        Report result = reportService.saveReport(report);
        return ResponseEntity.created(new URI("/reports/" + result.getId())).body(result);
    }
}
