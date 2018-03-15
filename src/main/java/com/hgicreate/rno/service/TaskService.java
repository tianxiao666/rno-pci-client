package com.hgicreate.rno.service;

import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import com.hgicreate.rno.web.rest.vm.TaskQueryVm;

import java.util.List;
import java.util.Optional;

/**
 * 查询具体任务
 *
 * @author chen.c10
 */
public interface TaskService {

    /**
     * 通过任务类型获取任务
     *
     * @param type 任务类型
     * @return 返回一个任务
     */
    Optional<? extends AbstractTaskDTO> findByType(JobType type);

    /**
     * 通过条件查询指定任务类型的作业列表
     *
     * @param type 任务类型
     * @param cond 查询条件
     * @return 任务列表
     */
    List<? extends AbstractTaskDTO> findAllByCondition(JobType type, TaskQueryVm cond);
}
