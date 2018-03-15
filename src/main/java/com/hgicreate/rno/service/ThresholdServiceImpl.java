package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Threshold;
import com.hgicreate.rno.repo.ThresholdRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen.c10
 */
@Service
public class ThresholdServiceImpl implements ThresholdService {
    private final ThresholdRepository thresholdRepository;

    public ThresholdServiceImpl(ThresholdRepository thresholdRepository) {
        this.thresholdRepository = thresholdRepository;
    }

    @Override
    public List<Threshold> findByModuleType(Threshold.ModuleType moduleType) {
        return thresholdRepository.findByModuleTypeOrderByOrder(moduleType);
    }

    @Override
    public List<Threshold> findAll(Threshold threshold) {
        Example<Threshold> example = Example.of(threshold);
        return thresholdRepository.findAll(example, new Sort("order"));
    }
}
