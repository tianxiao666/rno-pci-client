package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Threshold;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
public class ThresholdServiceTest {

    @Autowired
    private ThresholdService thresholdService;

    @Test
    public void findByModuleType() {
        List<Threshold> list = thresholdService.findByModuleType(Threshold.ModuleType.LTEINTERFERCALC);
        assertNotNull("空", list);
        list.forEach(System.out::println);
    }

    @Test
    public void findAll() {
        Threshold threshold = new Threshold();
        threshold.setModuleType(Threshold.ModuleType.LTEINTERFERCALC);
        List<Threshold> list = thresholdService.findAll(threshold);
        assertNotNull("空", list);
        list.forEach(System.out::println);
    }
}