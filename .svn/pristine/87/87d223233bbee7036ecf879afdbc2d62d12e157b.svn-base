package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.model.PciAfpTask;
import com.hgicreate.rno.service.dto.PciAfpTaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author chen.c10
 */
@Mapper(componentModel = "spring")
public interface PciAfpTaskMapper extends CommonTaskMapper<PciAfpTaskDTO, PciAfpTask> {
    PciAfpTaskMapper INSTANCE = Mappers.getMapper(PciAfpTaskMapper.class);

    /**
     * 对象转换为dto
     *
     * @param task 报告对象
     * @return 报告dto
     */
    @Override
    @Mapping(source = "area.name", target = "cityName")
    @Mapping(source = "job.name", target = "jobName")
    @Mapping(source = "job.runningStatus", target = "jobRunningStatus")
    @Mapping(source = "job.launchTime", target = "launchTime")
    @Mapping(source = "job.completeTime", target = "completeTime")
    @Mapping(source = "job.createTime", target = "createTime")
    PciAfpTaskDTO toDto(PciAfpTask task);
}
