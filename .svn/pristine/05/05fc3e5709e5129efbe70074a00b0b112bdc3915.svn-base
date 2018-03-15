package com.hgicreate.rno.web.client;

import com.hgicreate.rno.service.dto.AreaDTO;
import com.hgicreate.rno.service.dto.PciAfpResultDTO;
import com.hgicreate.rno.service.dto.ReportDTO;
import com.hgicreate.rno.service.dto.ThresholdDTO;
import com.hgicreate.rno.web.rest.vm.PciAfpSubmitTaskVm;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author li.tf
 */
@FeignClient(name = "${rno.lte.service.pci-afp:rno-lte-pci-afp-service}", fallback = PciAfpRestClientFallback.class)
public interface PciAfpRestClient {

    /**
     * 获取区域
     *
     * @return 区域集
     */
    @RequestMapping(value = "/area", method = RequestMethod.GET)
    List<AreaDTO> getArea();

    /**
     * 获取参数阈值
     *
     * @return 参数阈值集
     */
    @RequestMapping(value = "/threshold", method = RequestMethod.GET)
    List<ThresholdDTO> getThreshold();

    /**
     * 查询PCI计算结果
     *
     * @param jobId 任务ID
     * @return PCI计算结果集
     */
    @RequestMapping(value = "/task-result", method = RequestMethod.POST)
    List<PciAfpResultDTO> getResult(long jobId);

    /**
     * 提交任务
     *
     * @param vm 表单数据
     */
    @RequestMapping(value = "/submit-task", method = RequestMethod.POST)
    void submitTask(PciAfpSubmitTaskVm vm);

    /**
     * 下载PCI计算结果
     *
     * @param jobId 任务ID
     */
    @RequestMapping(value = "/download-result", method = RequestMethod.POST)
    void downloadResult(long jobId);

    /**
     * 获取任务报告
     *
     * @param jobId 任务ID
     * @return 任务结果集
     */
    @RequestMapping(value = "/task-report", method = RequestMethod.POST)
    List<ReportDTO> getReport(long jobId);

}