package com.hgicreate.rno.service;

import com.hgicreate.rno.model.JobStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
//@Transactional
public class JobServiceTest {
    @Autowired
    private JobService jobService;

    @Test
    public void findOne() {
    }

    @Test
    public void getFirstJobByType() {
    }

    @Test
    public void stopJobByJobId() {
    }

    @Test
    public void saveOne() {
    }

    @Test
    public void startJob() {
        jobService.startJob(9);
    }

    @Test
    public void endJob() {
        jobService.endJob(9, JobStatus.Fail, "计算完成");
    }
}