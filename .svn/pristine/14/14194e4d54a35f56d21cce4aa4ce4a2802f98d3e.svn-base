package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.model.Area;
import com.hgicreate.rno.service.dto.AreaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author chen.c10
 */
@Mapper
public interface AreaMapper extends EntityMapper<AreaDTO, Area> {
    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

    /**
     * 对象为dto
     *
     * @param entity 对象
     * @return dto
     */
    @Override
    @Mapping(source = "area.name", target = "areaName")
    AreaDTO entityToDto(Area entity);
}
