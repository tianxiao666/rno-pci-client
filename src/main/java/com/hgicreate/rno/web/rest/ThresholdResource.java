package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.model.Threshold;
import com.hgicreate.rno.service.ThresholdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen.c10
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ThresholdResource {
    private final ThresholdService thresholdService;

    public ThresholdResource(ThresholdService thresholdService) {
        this.thresholdService = thresholdService;
    }

    @GetMapping("/thresholds")
    public List<Threshold> findAll(Threshold threshold) {
        log.debug("findAll.threshold={}", threshold);
        return thresholdService.findAll(threshold);
    }
}
