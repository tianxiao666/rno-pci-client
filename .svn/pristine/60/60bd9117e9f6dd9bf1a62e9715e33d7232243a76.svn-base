package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.service.JobService;
import com.hgicreate.rno.service.dto.JobDTO;
import com.hgicreate.rno.service.dto.PciAfpResultDTO;
import com.hgicreate.rno.web.client.PciAfpRestClient;
import com.hgicreate.rno.web.rest.vm.JobQueryVm;
import com.hgicreate.rno.web.rest.vm.PciAfpSubmitTaskVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author li.tf
 */
@Slf4j
@RestController
@RequestMapping("/api/pci-afp")
public class PciAfpResource {

    private final PciAfpRestClient pciAfpRestClient;

    private final JobService jobService;

    public PciAfpResource(PciAfpRestClient pciAfpRestClient, JobService jobService) {
        this.pciAfpRestClient = pciAfpRestClient;
        this.jobService = jobService;
    }

    @PostMapping("/task-result")
    public List<PciAfpResultDTO> getResult(long jobId) {
        log.debug("jobId={}", jobId);
        return pciAfpRestClient.getResult(jobId);
    }

    @PostMapping("/task-detail")
    public List<JobDTO> queryTask(JobQueryVm vm) {
        log.debug("vm={}", vm);
        return jobService.findAllByCondition(vm);
    }

    @PostMapping("/submit-task")
    public void submitTask(PciAfpSubmitTaskVm vm) {
        log.debug("vm={}", vm);
    }

    @PostMapping("/download-result")
    @ResponseBody
    public void downloadResult(long jobId) {
        log.debug("jobId={}", jobId);
    }

}