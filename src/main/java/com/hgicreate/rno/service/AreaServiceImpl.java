package com.hgicreate.rno.service;

import com.hgicreate.rno.model.Area;
import com.hgicreate.rno.model.AreaLevel;
import com.hgicreate.rno.model.User;
import com.hgicreate.rno.repo.AreaRepository;
import com.hgicreate.rno.repo.UserRepository;
import com.hgicreate.rno.service.dto.AreaDTO;
import com.hgicreate.rno.service.mapper.AreaMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author chen.c10
 */
@Service
@CacheConfig(cacheNames = "areas_s")
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;
    private final UserRepository userRepository;

    public AreaServiceImpl(AreaRepository areaRepository, UserRepository userRepository) {
        this.areaRepository = areaRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable
    public List<AreaDTO> getAreaByAccount(String account, long cityCode) {
        // 获取省列表
        List<Area> provinces = areaRepository.findByLevel(AreaLevel.Province);
        if (provinces != null && !provinces.isEmpty()) {
            long topProvinceCode = -1;
            long topCityCode = -1;
            if (cityCode > 0) {
                topProvinceCode = findParent(provinces, cityCode);
                if (topProvinceCode > 0) {
                    topCityCode = cityCode;
                }
            } else {
                User user = userRepository.findByUsername(account);
                long defaultCity = user.getDefaultCity();
                if (defaultCity > 0) {
                    topProvinceCode = findParent(provinces, defaultCity);
                    if (topProvinceCode > 0) {
                        topCityCode = defaultCity;
                    }
                }
            }

            if (topProvinceCode > 0) {
                move2Top(provinces, topProvinceCode);
            }
        } else {
            return Collections.emptyList();
        }
        return AreaMapper.INSTANCE.entityListToDtoList(provinces);
    }

    private long findParent(List<Area> areas, long areaCode) {
        long parentCode = -1;
        for (Area province : areas) {
            List<Area> cities = null;
            if (cities != null && !cities.isEmpty()) {
                for (Area city : cities) {
                    if (city.getCode() == areaCode) {
                        parentCode = province.getCode();
                        break;
                    }
                }
            }
        }
        return parentCode;
    }

    private void move2Top(List<Area> areas, long areaCode) {
        if (areaCode > 0 && areas.size() > 0) {
            Area tmp = areas.get(0);
            for (int j = 0; j < areas.size(); j++) {
                if (areas.get(j).getCode() == areaCode) {
                    areas.set(0, areas.get(j));
                    areas.set(j, tmp);
                }
            }
        }
    }
}
