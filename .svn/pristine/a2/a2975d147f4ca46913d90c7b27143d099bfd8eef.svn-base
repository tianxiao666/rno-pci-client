package com.hgicreate.rno.service;

import com.hgicreate.rno.web.rest.vm.AzimuthEvaluationSubmitTaskVm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
//@Transactional
public class AzimuthEvaluationServiceTest {

    @Autowired
    private AzimuthEvaluationService azimuthEvaluationService;

    @Test
    public void saveAzimuthEvaluationJob() {
        AzimuthEvaluationSubmitTaskVm vm = new AzimuthEvaluationSubmitTaskVm();
        vm.setMode("input");
        vm.setTaskName("韶关测试2");
        vm.setCityId(440200L);
        vm.setAccount("liu.yp@hgicreate.com");
        vm.setEvaluationCells("827666-131,704596-11,827414-133,703854-13");
        boolean bool = azimuthEvaluationService.saveAzimuthEvaluationJob(vm);
        assertThat(bool).isTrue();
    }
}