package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobParam;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.repo.JobRepository;
import com.hgicreate.rno.web.rest.vm.AzimuthEvaluationSubmitTaskVm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.c10
 */
@Service
public class AzimuthEvaluationServiceImpl implements AzimuthEvaluationService {
    private final JobRepository jobRepository;

    public AzimuthEvaluationServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public boolean saveAzimuthEvaluationJob(AzimuthEvaluationSubmitTaskVm vm) {
        Job job = new Job();
        job.setAreaCode(vm.getCityId());
        job.setCreator(vm.getAccount());
        job.setModifier(vm.getAccount());
        job.setName(vm.getTaskName());
        job.setDescription(vm.getDescription());
        job.setType(JobType.RNO_LTE_AZIMUTH_EVALUATION);
        List<JobParam> params = new ArrayList<>();
        params.add(JobParam.of(JobParam.ParamType.PROPERTY, "mode", vm.getMode(), job));
        params.add(JobParam.of(JobParam.ParamType.PROPERTY, "cells", vm.getEvaluationCells(), job));
        job.setParams(params);
        return jobRepository.save(job) != null;
    }
}
