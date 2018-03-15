package com.hgicreate.rno.service;

import com.hgicreate.rno.web.rest.vm.PciAfpSubmitTaskVm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
//@Transactional
public class PciAfpServiceTest {

    @Autowired
    private PciAfpService pciAfpService;

    @Test
    public void savePciAfpJob() {
        PciAfpSubmitTaskVm vm = new PciAfpSubmitTaskVm();
        vm.setAccount("liu.yp@hgicreate.com");
        vm.setCityId(440200L);
        vm.setTaskName("韶关PCI测试1");
        vm.setDescription("描述");
        vm.setMode("test");
        vm.setOptimizeCells("827666-131,704596-11,827414-133,703854-13");
        vm.setConfig("config");
        vm.setCellm3rinterfercoef("1");
        vm.setScellm6rinterfercoef("0.8");
        vm.setCellm30rinterfercoef("0.1");
        vm.setBeforenstrongcelltab("6");
        vm.setTopncelllist("10");
        vm.setIncreasetopncelllist("5");
        vm.setConvermethod1targetval("5");
        vm.setConvermethod2targetval("5");
        vm.setConvermethod2scoren("10");
        vm.setDislimit("5000");
        boolean bool = pciAfpService.savePciAfpJob(vm);
        assertThat(bool).isTrue();
    }
}