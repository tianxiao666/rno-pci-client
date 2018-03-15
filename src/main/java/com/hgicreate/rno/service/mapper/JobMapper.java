package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.service.dto.JobDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author chen.c10
 */
@Mapper
public interface JobMapper extends EntityMapper<JobDTO, Job> {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    /**
     * 对象转换为dto
     *
     * @param job 报告对象
     * @return 报告dto
     */
    @Override
    @Mapping(source = "area.name", target = "areaName")
    JobDTO entityToDto(Job job);
}
