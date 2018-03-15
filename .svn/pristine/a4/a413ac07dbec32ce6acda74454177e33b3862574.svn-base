package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Report;
import com.hgicreate.rno.model.ReportType;
import com.hgicreate.rno.service.dto.ReportDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportServiceTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void getReportsByJobId() {
    }

    @Test
    public void getReportsByJobId2() {
        List<ReportDTO> reportDTOS = reportService.getReportsByJobId2(48);
        assertNotNull("空", reportDTOS);
        reportDTOS.forEach(System.out::println);
    }

    @Test
    public void saveReport() {
        Report report = new Report();
        report.setBegTime(LocalDateTime.now());
        report.setEndTime(LocalDateTime.now());
        report.setStage("任务启动");
        report.setState("全部成功");
        report.setAttMsg("天线方位角评估任务开始");
        report.setJobId(100L);
        report.setReportType(ReportType.System);
        report = reportService.saveReport(report);
        assertNotNull("空", report);
        System.out.println(report);
    }
}