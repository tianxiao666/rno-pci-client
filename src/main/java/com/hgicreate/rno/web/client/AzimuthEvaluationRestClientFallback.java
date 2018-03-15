package com.hgicreate.rno.web.client;

import com.hgicreate.rno.service.dto.AreaDTO;
import com.hgicreate.rno.service.dto.FileResult;
import com.hgicreate.rno.service.dto.ReportDTO;
import com.hgicreate.rno.service.dto.SubmitResult;
import com.hgicreate.rno.web.rest.vm.AzimuthEvaluationSubmitTaskVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 方位角评估REST接口异常处理
 *
 * @author li.tf
 * @date 2018-01-12 15:21:00
 */
@Slf4j
@Component
public class AzimuthEvaluationRestClientFallback implements AzimuthEvaluationRestClient {

    @Override
    public List<AreaDTO> getArea() {
        log.debug("获取区域失败。");
        return Collections.emptyList();
    }

    @Override
    public SubmitResult startTask(long jobId) {
        log.debug("任务执行失败。");
        return submitTaskFail();
    }

    @Override
    public FileResult downloadResult(long jobId) {
        log.debug("下载结果文件失败。");
        return downloadFileFail("下载结果文件失败。");
    }

    @Override
    public FileResult downloadEnhancePlan(long jobId) {
        log.debug("下载增强方案文件失败。");
        return downloadFileFail("下载增强方案文件失败。");
    }

    @Override
    public List<ReportDTO> getReport(long jobId) {
        log.debug("获取报告失败。");
        return Collections.emptyList();
    }

    @Override
    public SubmitResult submitTask(AzimuthEvaluationSubmitTaskVm vm) {
        log.debug("提交任务失败。");
        return submitTaskFail();
    }

    @Override
    public List getResult(long jobId) {
        log.debug("获取计算结果失败。");
        return Collections.emptyList();
    }

    @Override
    public List getEnhancePlan(long jobId) {
        log.debug("获取网络覆盖增强方案失败。");
        return Collections.emptyList();
    }

    /**
     * 下载文件出错
     *
     * @param msg 错误信息
     * @return 文件结果对象
     * @date 2018-01-12 15:23:00
     */
    private static FileResult downloadFileFail(String msg) {
        FileResult fileResult = new FileResult();
        fileResult.setResult(false);
        fileResult.setMsg(msg);
        fileResult.setStatusCode(HttpStatus.BAD_GATEWAY.value());
        return fileResult;
    }

    /**
     * 提交任务出错
     *
     * @return 提交结果对象
     * @date 2018-01-12 15:23:23
     */
    private static SubmitResult submitTaskFail() {
        SubmitResult submitResult = new SubmitResult();
        submitResult.setFlag(false);
        submitResult.setResult("任务执行失败。");
        return submitResult;
    }

}
