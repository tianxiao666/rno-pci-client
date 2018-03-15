package com.hgicreate.rno.service.mapper;

import com.hgicreate.rno.model.AbstractTask;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;

/**
 * 作业转换类的抽象接口，所有新作业继承这个接口
 *
 * @author chen.c10
 */
public interface CommonTaskMapper<D extends AbstractTaskDTO, E extends AbstractTask> extends EntityMapper<D, E> {
}
