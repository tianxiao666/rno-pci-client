package com.hgicreate.rno.service;

import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.dto.JobDTO;
import com.hgicreate.rno.web.rest.vm.JobQueryVm;

import java.util.List;

/**
 * 任务服务接口
 *
 * @author chen.c10
 */
public interface JobService {

    /**
     * 通过任务ID获取一个任务dto对象
     *
     * @param jobId 任务ID
     * @return 任务dto对象
     */
    JobDTO findOne(Long jobId);

    /**
     * 通过任务类型获取任务对象
     *
     * @param type 任务类型
     * @return 获取到的第一个任务对象
     */
    JobDTO getFirstJobByType(JobType type);

    /**
     * 通过任务ID停止一个任务
     *
     * @param jobId 任务ID
     * @return 是否停止
     */
    boolean stopJobByJobId(Long jobId);

    boolean saveOne();

    void startJob(long id);

    void endJob(long id, JobStatus status, String finishState);

    List<JobDTO> findAllByCondition(JobQueryVm vm);
}
