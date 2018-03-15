package com.hgicreate.rno.web.client;

import com.hgicreate.rno.service.dto.AreaDTO;
import com.hgicreate.rno.service.dto.FileResult;
import com.hgicreate.rno.service.dto.ReportDTO;
import com.hgicreate.rno.service.dto.SubmitResult;
import com.hgicreate.rno.web.rest.vm.AzimuthEvaluationSubmitTaskVm;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 方位角评估REST接口
 *
 * @author li.tf
 * @date 2018-01-12 15:07:04
 */
@FeignClient(name = "${rno.lte.service.azimuth-evaluation:rno-lte-azimuth-evaluation-service}", fallback = AzimuthEvaluationRestClientFallback.class)
public interface AzimuthEvaluationRestClient {

    /**
     * 获取区域
     *
     * @return 区域集
     * @date 2018-01-12 15:07:15
     */
    @RequestMapping(value = "/area", method = GET)
    List<AreaDTO> getArea();

    /**
     * 开始任务
     *
     * @param jobId 任务ID
     * @return 结果对象
     * @date 2018-01-12 15:07:27
     */
    @RequestMapping(value = "/start-task/{jobId}", method = GET)
    SubmitResult startTask(@PathVariable("jobId") long jobId);

    /**
     * 下载方位角评估结果文件
     *
     * @param jobId 任务ID
     * @return 文件对象
     * @date 2018-01-12 15:07:40
     */
    @RequestMapping(value = "/download-result/{jobId}")
    FileResult downloadResult(@PathVariable("jobId") long jobId);

    /**
     * 下载增强方案文件
     *
     * @param jobId 任务ID
     * @return 文件对象
     * @date 2018-01-12 15:08:04
     */
    @RequestMapping(value = "/download-enhance/{jobId}")
    FileResult downloadEnhancePlan(@PathVariable("jobId") long jobId);

    /**
     * 查询报告
     *
     * @param jobId 任务ID
     * @return 报告集
     * @date 2018-01-12 15:09:01
     */
    @RequestMapping(value = "/query-report/{jobId}", method = GET)
    List<ReportDTO> getReport(@PathVariable("jobId") long jobId);

    /**
     * 提交任务
     *
     * @param vm 表单数据
     * @return 提交任务结果
     * @date 2018-01-12 15:10:04
     */
    @RequestMapping(value = "/submit-task", method = POST)
    SubmitResult submitTask(@RequestBody AzimuthEvaluationSubmitTaskVm vm);

    /**
     * 查询1000条方位角评估结果
     *
     * @param jobId 任务ID
     * @return 1000条方位角评估结果数据
     * @date 2018-01-12 15:11:56
     */
    @RequestMapping(value = "/query-1000-result/{jobId}", method = GET)
    List getResult(@PathVariable("jobId") long jobId);

    /**
     * 查询1000条增强方案结果
     *
     * @param jobId 任务ID
     * @return 1000条增强方案结果数据
     * @date 2018-01-12 15:12:04
     */
    @RequestMapping(value = "/query-1000-enhance/{jobId}", method = GET)
    List getEnhancePlan(@PathVariable("jobId") long jobId);

}