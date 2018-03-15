package com.hgicreate.rno.repo;

import com.hgicreate.rno.model.Threshold;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "eureka.client.enabled=false")
//@Transactional
public class ThresholdRepositoryTest {

    @Autowired
    private ThresholdRepository thresholdRepository;

    @Test
    public void findByModuleTypeOrderByOrder() {
        List<Threshold> list = thresholdRepository.findByModuleTypeOrderByOrder(Threshold.ModuleType.LTEINTERFERCALC);
        assertThat(list, notNullValue());
        list.forEach(System.out::println);
    }
}