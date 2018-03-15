package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.model.JobParam;
import com.hgicreate.rno.service.dto.JobParamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author chen.c10
 */
@Mapper
public interface JobParamMapper extends EntityMapper<JobParamDTO, JobParam> {
    JobParamMapper INSTANCE = Mappers.getMapper(JobParamMapper.class);

    /**
     * 对象转换为dto
     *
     * @param job 报告对象
     * @return 报告dto
     */
    @Override
    JobParamDTO entityToDto(JobParam job);
}
