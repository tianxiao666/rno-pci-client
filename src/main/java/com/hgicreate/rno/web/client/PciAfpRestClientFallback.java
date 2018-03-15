package com.hgicreate.rno.web.client;

import com.hgicreate.rno.service.dto.AreaDTO;
import com.hgicreate.rno.service.dto.PciAfpResultDTO;
import com.hgicreate.rno.service.dto.ReportDTO;
import com.hgicreate.rno.service.dto.ThresholdDTO;
import com.hgicreate.rno.web.rest.vm.PciAfpSubmitTaskVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author li.tf
 */
@Slf4j
@Component
public class PciAfpRestClientFallback implements PciAfpRestClient {

    @Override
    public List<AreaDTO> getArea() {
        log.debug("获取区域失败。");
        return Collections.emptyList();
    }

    @Override
    public List<ThresholdDTO> getThreshold() {
        log.debug("获取参数阈值失败。");
        return Collections.emptyList();
    }

    @Override
    public List<PciAfpResultDTO> getResult(long jobId) {
        log.debug("获取任务结果失败。");
        return Collections.emptyList();
    }

    @Override
    public void submitTask(PciAfpSubmitTaskVm vm) {
        log.debug("提交任务失败。");
    }

    @Override
    public void downloadResult(long jobId) {
        log.debug("下载文件失败。");
    }

    @Override
    public List<ReportDTO> getReport(long jobId) {
        log.debug("获取任务报告失败。");
        return Collections.emptyList();
    }

}
