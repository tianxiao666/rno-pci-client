package com.hgicreate.rno.service;

import com.hgicreate.rno.model.AzimuthEvaluationTask;
import com.hgicreate.rno.repo.AzimuthEvaluationTaskRepository;
import com.hgicreate.rno.service.dto.AzimuthEvaluationTaskDTO;
import com.hgicreate.rno.service.mapper.AzimuthEvaluationTaskMapper;
import org.springframework.stereotype.Service;

/**
 * 天线方位角作业服务的实现类，继承抽象任务服务类获得缺省实现。
 *
 * @author chen.c10
 */
@Service
public class AzimuthEvaluationTaskServiceImpl extends AbstractCommonTaskService<AzimuthEvaluationTask, AzimuthEvaluationTaskDTO, AzimuthEvaluationTaskRepository, AzimuthEvaluationTaskMapper> implements AzimuthEvaluationTaskService {
    public AzimuthEvaluationTaskServiceImpl(AzimuthEvaluationTaskRepository repository, AzimuthEvaluationTaskMapper mapper) {
        super(repository, mapper);
    }
}
