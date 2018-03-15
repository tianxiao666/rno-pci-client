package com.hgicreate.rno.service;

import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import com.hgicreate.rno.web.rest.vm.TaskQueryVm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    //    private JobType jobType = JobType.RNO_TEST_TASK;
//    private JobType jobType = JobType.RNO_PCI_AFP_PLAN;
    private JobType jobType = JobType.RNO_LTE_AZIMUTH_EVALUATION;

    @Test
    public void findByType() {
        Optional<? extends AbstractTaskDTO> task = taskService.findByType(jobType);
        System.out.println(task);
    }

    @Test
    public void findAllByCondition() {
        TaskQueryVm cond = new TaskQueryVm();
//        cond.setCityId(440200);
        cond.setCityId(440100);
        cond.setTaskStatus("Waiting");
        List<? extends AbstractTaskDTO> list = taskService.findAllByCondition(jobType, cond);
        list.forEach(System.out::println);
    }
}