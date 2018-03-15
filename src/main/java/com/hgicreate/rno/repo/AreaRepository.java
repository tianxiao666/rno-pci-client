package com.hgicreate.rno.repo;

import com.hgicreate.rno.model.Area;
import com.hgicreate.rno.model.AreaLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author chen.c10
 */
public interface AreaRepository extends JpaRepository<Area, Long> {
    /**
     * 通过区域级别获取区域列表
     *
     * @param level 区域级别
     * @return 区域列表
     */
    List<Area> findByLevel(@Param("level") AreaLevel level);
}
