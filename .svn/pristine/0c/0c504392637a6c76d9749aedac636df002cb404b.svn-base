package com.hgicreate.rno.service;

import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.dto.AbstractTaskDTO;
import com.hgicreate.rno.web.rest.vm.TaskQueryVm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 作业服务实现类
 *
 * @author chen.c10
 */
@Service
public class TaskServiceImpl implements TaskService {
    private final Map<JobType, CommonTaskService> taskServiceMap = new HashMap<>(2);

    public TaskServiceImpl(PciAfpTaskService pciAfpTaskService, AzimuthEvaluationTaskService azimuthEvaluationTaskService) {
        taskServiceMap.put(JobType.RNO_PCI_AFP_PLAN, pciAfpTaskService);
        taskServiceMap.put(JobType.RNO_LTE_AZIMUTH_EVALUATION, azimuthEvaluationTaskService);
    }

    @Override
    public Optional<? extends AbstractTaskDTO> findByType(JobType type) {
        return taskServiceMap.get(type).findFirstByJobRunningStatusOrderByJobCreateTimeDesc(JobStatus.Waiting);
    }

    @Override
    public List<? extends AbstractTaskDTO> findAllByCondition(JobType type, TaskQueryVm cond) {
        return taskServiceMap.get(type).findAllByCondition(cond);
    }
}
