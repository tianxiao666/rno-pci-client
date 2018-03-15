package com.hgicreate.rno.service;

import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import com.hgicreate.rno.web.rest.vm.TaskQueryVm;

import java.util.List;
import java.util.Optional;

/**
 * @author chen.c10
 */
public interface CommonTaskService {
    /**
     * 通过任务类型获取任务
     *
     * @param status 任务状态
     * @return 返回一个任务的DTO
     */
    Optional<? extends AbstractTaskDTO> findFirstByJobRunningStatusOrderByJobCreateTimeDesc(JobStatus status);

    /**
     * 通过条件查询指定任务类型的作业列表
     *
     * @param cond 查询条件
     * @return 任务DTO列表
     */
    List<? extends AbstractTaskDTO> findAllByCondition(TaskQueryVm cond);
}
