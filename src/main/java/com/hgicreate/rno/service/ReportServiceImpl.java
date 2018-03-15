package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Report;
import com.hgicreate.rno.repo.ReportRepository;
import com.hgicreate.rno.service.dto.ReportDTO;
import com.hgicreate.rno.service.mapper.ReportMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 报告服务实现类
 *
 * @author chen.c10
 */
@CacheConfig(cacheNames = "reports")
@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Cacheable
    @Override
    public ReportDTO getReport(long id) {
        return ReportMapper.INSTANCE.entityToDto(reportRepository.getOne(id));
    }

    @Cacheable
    @Override
    public List<Report> getReportsByJobId(long jobId) {
        return reportRepository.findByJobId(jobId);
    }

    @Cacheable
    @Override
    public List<ReportDTO> getReportsByJobId2(long jobId) {
        return ReportMapper.INSTANCE.entityListToDtoList(reportRepository.findByJobId(jobId));
    }

    @CachePut
    @Override
    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    @Cacheable
    @Override
    public List<ReportDTO> findAll(Report report) {
        Example<Report> example = Example.of(report);
        return ReportMapper.INSTANCE.entityListToDtoList(reportRepository.findAll(example));
    }
}