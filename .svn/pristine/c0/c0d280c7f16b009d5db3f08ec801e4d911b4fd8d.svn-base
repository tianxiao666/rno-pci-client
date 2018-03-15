package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Job;
import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.repo.JobRepository;
import com.hgicreate.rno.service.dto.JobDTO;
import com.hgicreate.rno.service.mapper.JobMapper;
import com.hgicreate.rno.web.rest.vm.JobQueryVm;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen.c10
 */
@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobDTO findOne(Long jobId) {
        return JobMapper.INSTANCE.entityToDto(jobRepository.findOne(jobId));
    }

    @Override
    public JobDTO getFirstJobByType(JobType type) {
        List<Job> jobs = jobRepository.findByRunningStatusAndTypeOrderByCreateTimeDesc(JobStatus.Waiting, type);
        if (jobs == null || jobs.size() == 0) {
            return null;
        }
        return JobMapper.INSTANCE.entityToDto(jobs.get(0));
    }

    @Override
    public boolean stopJobByJobId(Long jobId) {
        return false;
    }

    @Override
    public boolean saveOne() {
        return false;
    }

    @Override
    public void startJob(long id) {
        Job job = jobRepository.findOne(id);
        job.setRunningStatus(JobStatus.Running);
        jobRepository.save(job);
    }

    @Override
    public void endJob(long id, JobStatus status, String finishState) {
        Job job = jobRepository.findOne(id);
        job.setRunningStatus(status);
        job.setFinishState(finishState);
        jobRepository.save(job);
    }

    @Override
    public List<JobDTO> findAllByCondition(JobQueryVm vm) {
        return JobMapper.INSTANCE.entityListToDtoList(jobRepository.findAll(vm));
    }
}
