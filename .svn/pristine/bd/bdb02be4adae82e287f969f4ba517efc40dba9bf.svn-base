package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.model.JobType;
import com.hgicreate.rno.service.JobService;
import com.hgicreate.rno.service.dto.FileResult;
import com.hgicreate.rno.service.dto.JobDTO;
import com.hgicreate.rno.service.dto.ReportDTO;
import com.hgicreate.rno.service.dto.SubmitResult;
import com.hgicreate.rno.web.client.AzimuthEvaluationRestClient;
import com.hgicreate.rno.web.rest.vm.AzimuthEvaluationSubmitTaskVm;
import com.hgicreate.rno.web.rest.vm.JobQueryVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 方位角评估API
 *
 * @author li.tf
 * @date 2018-01-12 14:49:20
 */
@Slf4j
@RestController
@RequestMapping("/api/azimuth-evaluation")
public class AzimuthEvaluationResource {

    private final AzimuthEvaluationRestClient azimuthEvaluationRestClient;

    private final JobService jobService;

    public AzimuthEvaluationResource(AzimuthEvaluationRestClient azimuthEvaluationRestClient, JobService jobService) {
        this.azimuthEvaluationRestClient = azimuthEvaluationRestClient;
        this.jobService = jobService;
    }

    /**
     * 获取方位角评估结果
     *
     * @param jobId 任务ID
     * @return 方位角评估结果
     * @date 2018-01-12 14:50:49
     */
    @GetMapping("/task-result")
    public List getResult(long jobId) {
        log.debug("id={}", jobId);
        List list = azimuthEvaluationRestClient.getResult(jobId);
        log.debug("list={}", list);
        return list;
    }

    /**
     * 查询任务
     *
     * @param vm 查询条件
     * @return 任务信息
     * @date 2018-01-12 14:51:29
     */
    @PostMapping("/task-detail")
    public List<JobDTO> queryTask(JobQueryVm vm) {
        log.debug("vm={}", vm);
        vm.setJobType(JobType.RNO_LTE_AZIMUTH_EVALUATION);
        return jobService.findAllByCondition(vm);
    }

    /**
     * 查询报告
     *
     * @param jobId 任务ID
     * @return 报告集
     * @date 2018-01-12 14:52:39
     */
    @GetMapping("/task-report")
    public List<ReportDTO> getReport(long jobId) {
        log.debug("id={}", jobId);
        return azimuthEvaluationRestClient.getReport(jobId);
    }

    /**
     * 获取增强方案
     *
     * @param jobId 任务ID
     * @return 增强方案
     * @date 2018-01-12 14:53:38
     */
    @GetMapping("/enhance-plan")
    public List getEnhancePlan(long jobId) {
        log.debug("id={}", jobId);
        return azimuthEvaluationRestClient.getEnhancePlan(jobId);
    }

    /**
     * 提交任务
     *
     * @param vm 任务条件
     * @return 提交结果
     * @date 2018-01-12 14:54:38
     */
    @PostMapping("/submit-task")
    public SubmitResult submitTask(AzimuthEvaluationSubmitTaskVm vm) {
        log.debug("vm={}", vm);
        String msg = "未知错误";
        SubmitResult submitResult = new SubmitResult();
        submitResult.setFlag(false);

        try {
            submitResult = azimuthEvaluationRestClient.submitTask(vm);
            if (null != submitResult && submitResult.isFlag()) {
                submitResult = azimuthEvaluationRestClient.startTask(submitResult.getJobId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "创建天线方位角评估任务失败！";
            log.error(msg);
        }
        if (submitResult == null) {
            submitResult = new SubmitResult();
            submitResult.setFlag(false);
            submitResult.setResult(msg);
        }
        log.debug("退出方法：submitTask。submitResult={}", submitResult);
        return submitResult;
    }

    /**
     * 下载方位角评估结果
     *
     * @param jobId 任务ID
     * @return 方位角评估结果文件
     * @date 2018-01-12 14:55:49
     */
    @RequestMapping("/download-result")
    @ResponseBody
    public ResponseEntity downloadResult(long jobId) {
        log.debug("downloadResult.id={}", jobId);
        FileResult fileResult = azimuthEvaluationRestClient.downloadResult(jobId);
        return downloadFile(fileResult);
    }

    /**
     * 下载增强方案
     *
     * @param jobId 任务ID
     * @return 增强方案结果文件
     * @date 2018-01-12 14:56:48
     */
    @RequestMapping("/download-enhance")
    @ResponseBody
    public ResponseEntity downloadEnhancePlan(long jobId) {
        log.debug("downloadEnhancePlan.id={}", jobId);
        FileResult fileResult = azimuthEvaluationRestClient.downloadEnhancePlan(jobId);
        return downloadFile(fileResult);
    }

    /**
     * 下载文件公共方法
     *
     * @param fileResult 文件信息
     * @return 文件
     * @date 2018-01-12 15:00:00
     */
    private ResponseEntity downloadFile(FileResult fileResult) {
        if (null == fileResult) {
            log.error("未获取到文件！");
            return new ResponseEntity<>("未获取到文件！", HttpStatus.SERVICE_UNAVAILABLE);
        }

        if (fileResult.isResult()) {
            byte[] fileBody = fileResult.getFileBody();

            if (fileResult.getFileLength() != fileBody.length) {
                log.error("文件流不完整！");
                return new ResponseEntity<>("文件流不完整！", HttpStatus.SERVICE_UNAVAILABLE);
            }

            String fileName = fileResult.getFilename();
            try {
                fileName = new String(fileResult.getFilename().getBytes("UTF-8"),
                        "iso-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            log.debug(fileResult.getMsg());
            return new ResponseEntity<>(fileBody, headers, HttpStatus.valueOf(fileResult.getStatusCode()));
        } else {
            log.error(fileResult.getMsg());
            return new ResponseEntity<>(fileResult.getMsg(), HttpStatus.valueOf(fileResult.getStatusCode()));
        }
    }

}