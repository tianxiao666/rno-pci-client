package com.hgicreate.rno.web.rest;

import com.hgicreate.rno.service.AreaService;
import com.hgicreate.rno.service.dto.AreaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen.c10
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class AreaResource {
    private final AreaService areaService;

    public AreaResource(AreaService areaService) {
        this.areaService = areaService;
    }

    /**
     * 获取区域
     *
     * @return 区域集
     */
    @GetMapping("/areas")
    public List<AreaDTO> getAreaByAccount(String account, long defaultCityCode) {
        return areaService.getAreaByAccount(account, defaultCityCode);
    }
}
