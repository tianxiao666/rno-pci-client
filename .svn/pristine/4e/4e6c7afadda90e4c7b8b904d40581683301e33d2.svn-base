package com.hgicreate.rno.service;

import com.hgicreate.rno.service.dto.AreaDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaByAccount() {
        List<AreaDTO> areaDTOS = areaService.getAreaByAccount("liu.yp@hgicreate.com", 440200L);
        Assertions.assertThat(areaDTOS).isNotEmpty();
        areaDTOS.forEach(System.out::println);
    }
}