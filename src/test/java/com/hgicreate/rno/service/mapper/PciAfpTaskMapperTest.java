package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.PciAfpTask;
import com.hgicreate.rno.service.dto.PciAfpTaskDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PciAfpTaskMapperTest {

    @Autowired
    private PciAfpTaskMapper pciAfpTaskMapper;

    @Test
    public void toDto() {
        PciAfpTask task = new PciAfpTask() {
            {
                setJob(new Job() {{
                    setName("hehe");
                }});
            }
        };
        PciAfpTaskDTO dto = pciAfpTaskMapper.toDto(task);
        System.out.println(dto);
    }

    @Test
    public void toDto2() {
        List<PciAfpTask> list = IntStream.range(1, 10).mapToObj(i -> new PciAfpTask() {
            {
                setJob(new Job() {
                    {
                        setName("hehe" + i);
                    }
                });
            }
        }).collect(Collectors.toList());
        List<PciAfpTaskDTO> dtoList = pciAfpTaskMapper.toDtoList(list);
        dtoList.forEach(System.out::println);
    }
}