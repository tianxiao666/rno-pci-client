package com.hgicreate.rno.repo;

import com.hgicreate.rno.model.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chen.c10
 */
public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
    /**
     * 通过任务运行状态和任务类型并按创建时间降序排列获取一个任务
     *
     * @param type 模块类型
     * @return 任务对象
     */
    List<Threshold> findByModuleTypeOrderByOrder(Threshold.ModuleType type);
}
