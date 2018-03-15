package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.model.JobStatus;
import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.JobService;
import com.hgicreate.rno.service.dto.JobDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen.c10
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class JobResource {
    private final JobService jobService;

    public JobResource(JobService jobService) {
        this.jobService = jobService;
    }

    /**
     * 获取相应状态下的任务ID
     */
    @GetMapping("/jobs/find-one-by-status-and-type")
    public JobDTO getFirstJobByStatusAndType(JobType type) {
        log.info("进入方法：getFirstJobByStatusAndType。type={}", type);
        JobDTO jobDTO = jobService.getFirstJobByType(type);
        log.info("退出方法：getFirstJobByStatusAndType。jobDTO={}", jobDTO);
        return jobDTO;
    }

    /**
     * 根据任务ID获取任务名称
     */
    @GetMapping("/jobs/{id}")
    public JobDTO findOne(@PathVariable("id") Long id) {
        log.info("进入方法：findOne。id={}", id);
        JobDTO jobDTO = jobService.findOne(id);
        log.debug("退出方法：findOne。jobDTO={}", jobDTO);
        return jobDTO;
    }

    /**
     * 开始任务
     *
     * @param id 任务ID
     */
    @PutMapping("/jobs/{id}/start")
    public void startJob(@PathVariable("id") long id) {
        log.info("进入方法：startJob。id={}", id);
        jobService.startJob(id);
        log.debug("退出方法：startJob");
    }

    /**
     * 开始任务
     *
     * @param id          任务ID
     * @param status      任务结束状态
     * @param finishState 完成情况
     */
    @PutMapping("/api/jobs/{id}/end")
    public void endJob(@PathVariable("id") long id, JobStatus status, String finishState) {
        log.info("进入方法：endJob。id={},status={},finishState={}", id, status, finishState);
        jobService.endJob(id, status, finishState);
        log.debug("退出方法：endJob");
    }

    /**
     * 终止任务
     */
    @RequestMapping("/jobs/stop-one/{id}")
    public Map<String, Object> stopJobByJobId2(@PathVariable("id") Long id) {
        log.debug("进入方法：stopJobByJobId。id={}", id);

        Map<String, Object> map = new HashMap<>(2);
        String msg = "任务已停止";
        if (id == null || id <= 0) {
            msg = "未传入一个有效的jobId！无法停止任务！";
            log.error(msg);
            map.put("flag", false);
            map.put("result", msg);
            return map;
        }
        boolean result = jobService.stopJobByJobId(id);
        if (result) {
            log.debug("stopJobByJobId。任务<{}>停止成功", id);
        }
        map.put("flag", true);
        map.put("result", msg);
        return map;
    }
}
