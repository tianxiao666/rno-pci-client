package com.hgicreate.rno.service;

import com.hgicreate.rno.model.AbstractTask;
import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.repo.CommonTaskRepository;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import com.hgicreate.rno.service.mapper.CommonTaskMapper;
import com.hgicreate.rno.web.rest.vm.TaskQueryVm;

import java.util.List;
import java.util.Optional;

/**
 * 查询具体任务
 *
 * @author chen.c10
 */
public abstract class AbstractCommonTaskService<E extends AbstractTask, D extends AbstractTaskDTO,
        R extends CommonTaskRepository<E, Long>, M extends CommonTaskMapper<D, E>>
        implements CommonTaskService {

    private R repository;

    protected M mapper;

    AbstractCommonTaskService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * 通过任务类型获取任务
     *
     * @param status 任务状态
     * @return 返回一个任务
     */
    @Override
    public Optional<D> findFirstByJobRunningStatusOrderByJobCreateTimeDesc(JobStatus status) {
        return Optional.of(mapper.toDto(repository.findFirstByJobRunningStatusOrderByJobCreateTimeDesc(status)));
    }

    /**
     * 通过条件查询指定任务类型的作业列表
     *
     * @param cond 查询条件
     * @return 任务列表
     */
    @Override
    public List<D> findAllByCondition(TaskQueryVm cond) {
        return mapper.toDtoList(repository.findAll(cond));
    }
}
