package com.hgicreate.rno.repo;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobParam;
import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.web.rest.vm.JobQueryVm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
@Transactional
public class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobParamRepository jobParamRepository;

    @Test
    public void findByRunningStatusAndTypeOrderByCreateTimeDesc() {
        List<Job> jobs = jobRepository.findByRunningStatusAndTypeOrderByCreateTimeDesc(JobStatus.Waiting, JobType.RNO_TEST_TASK);
    }

    @Test
    public void findAll() {
        List<Job> jobs = jobRepository.findAll();
        if (jobs != null) {
            jobs.forEach(System.out::println);
        }
    }

    @Test
    public void save() {
        Job job = new Job();
        job.setAreaCode(440200L);
        job.setName("name1");
        job.setType(JobType.RNO_TEST_TASK);
        job.setDescription("yoyo");
        job.setCreator("liu.yp@hgicreate.com");
        Job newJob = jobRepository.save(job);
        System.out.println(newJob);
        for (int i = 0; i < 5; i++) {
            JobParam param = new JobParam();
            param.setJob(job);
            param.setCode("code" + i);
            param.setValue("value" + i);
            param.setType(JobParam.ParamType.TEST);
            jobParamRepository.save(param);
        }
        newJob = jobRepository.findOne(job.getId());
        System.out.println(newJob);
    }

    @Test
    public void findAll1() {
        JobQueryVm vm = new JobQueryVm();
        vm.setCityId(440200L);
        vm.setAccount("liu.yp@hgicreate.com");
        vm.setJobType(JobType.RNO_PCI_AFP_PLAN);
        List<Job> jobs = jobRepository.findAll(vm);
        if (jobs != null) {
            jobs.forEach(System.out::println);
        }
    }
}