package com.hgicreate.rno.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.repo.JobRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
@AutoConfigureMockMvc
public class JobResourceTest {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<Job> json;

    @Before
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void saveJob() throws Exception {
//        jobRepository.findOne(100L);
//        int databaseSizeBeforeCreate = jobRepository.findAll().size();
        Job job = new Job();
        job.setType(JobType.RNO_TEST_TASK);
        job.setName("测试任务");
        MockHttpServletResponse result = mockMvc.perform(
                post("/jobs")
                        .contentType(MediaType.parseMediaType("application/json;charset=UTF-8"))
                        .content(json.write(job).getJson())
        ).andExpect(status().isCreated()).andReturn().getResponse();
        System.out.println(result.getStatus());
        System.out.println(result.getContentAsString());
        List<Job> list = jobRepository.findAll();
        System.out.println("************************************");
        System.out.println(list.size());
        System.out.println("************************************");
//        assertThat(list).hasSize(databaseSizeBeforeCreate + 1);
        Job testReport = list.get(list.size() - 1);
        System.out.println(testReport);
    }

    @Test
    public void getOneJob() {
    }

    @Test
    public void getFirstJobByStatusAndType() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void stopJobByJobId() {
    }

    @Test
    public void stopJobByJobId2() {
    }
}