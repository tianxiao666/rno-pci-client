package com.hgicreate.rno.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgicreate.rno.model.Report;
import com.hgicreate.rno.model.ReportType;
import com.hgicreate.rno.repo.ReportRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportResourceTest {

    @Autowired
    private ReportRepository reportRepository;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private JacksonTester<Report> json;

    public ReportResourceTest() {
    }

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void getReportsByJobId() {
    }

    @Test
    public void saveReport() {

    }

    @Test
    public void saveReport2() throws Exception {
        int databaseSizeBeforeCreate = reportRepository.findAll().size();
        Report report = new Report();
//        report.setId(8L);
        report.setBegTime(LocalDateTime.now());
        report.setEndTime(LocalDateTime.now());
        report.setStage("任务启动");
        report.setState("全部成功");
        report.setAttMsg("天线方位角评估任务开始");
        report.setJobId(100L);
        report.setReportType(ReportType.System);
        MockHttpServletResponse result = mockMvc.perform(
                post("/reports")
                        .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
                        .content(json.write(report).getJson())
        ).andExpect(status().isCreated()).andReturn().getResponse();
        System.out.println(result.getStatus());
        System.out.println(result.getContentAsString());
        List<Report> reports = reportRepository.findAll();
//        System.out.println("************************************");
//        System.out.println(reports.size());
//        System.out.println("************************************");
        assertThat(reports).hasSize(databaseSizeBeforeCreate + 1);
        Report testReport = reports.get(reports.size() - 1);
        System.out.println(testReport);
    }

    @Test
    public void getReport() throws Exception {
        MockHttpServletResponse result = mockMvc.perform(
                get("/reports/8")
                        .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
        ).andExpect(status().isOk()).andReturn().getResponse();
        System.out.println(result.getStatus());
        System.out.println(result.getContentAsString());
    }

    @Test
    public void findByJobId() throws Exception {
        MockHttpServletResponse result = mockMvc.perform(
                get("/reports/find-by-job-id/100")
                        .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
        ).andExpect(status().isOk()).andReturn().getResponse();
        System.out.println(result.getStatus());
        System.out.println(result.getContentAsString());
    }
}