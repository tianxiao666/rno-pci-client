package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobParam;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.repo.JobRepository;
import com.hgicreate.rno.web.rest.vm.PciAfpSubmitTaskVm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen.c10
 */
@Service
public class PciAfpServiceImpl implements PciAfpService {
    private final JobRepository jobRepository;

    public PciAfpServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public boolean savePciAfpJob(PciAfpSubmitTaskVm vm) {
        Job job = new Job();
        job.setAreaCode(vm.getCityId());
        job.setCreator(vm.getAccount());
        job.setModifier(vm.getAccount());
        job.setName(vm.getTaskName());
        job.setType(JobType.RNO_PCI_AFP_PLAN);
        job.setDescription(vm.getDescription());
        List<JobParam> params = new ArrayList<>();
        params.add(JobParam.of(JobParam.ParamType.PROPERTY, "mode", vm.getMode(), job));
        params.add(JobParam.of(JobParam.ParamType.PROPERTY, "cells", vm.getOptimizeCells(), job));
        params.add(JobParam.of(JobParam.ParamType.PROPERTY, "config", vm.getConfig(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "cellm3rinterfercoef", vm.getCellm3rinterfercoef(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "scellm6rinterfercoef", vm.getScellm6rinterfercoef(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "cellm30rinterfercoef", vm.getCellm30rinterfercoef(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "topncelllist", vm.getTopncelllist(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "increasetopncelllist", vm.getIncreasetopncelllist(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "beforenstrongcelltab", vm.getBeforenstrongcelltab(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "convermethod1targetval", vm.getConvermethod1targetval(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "convermethod2targetval", vm.getConvermethod2targetval(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "convermethod2scoren", vm.getConvermethod2scoren(), job));
        params.add(JobParam.of(JobParam.ParamType.THRESHOLD, "dislimit", vm.getDislimit(), job));
        job.setParams(params);
        return jobRepository.save(job) != null;
    }
}
