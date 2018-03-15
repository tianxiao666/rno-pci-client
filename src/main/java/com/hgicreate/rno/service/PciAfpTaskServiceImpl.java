package com.hgicreate.rno.service;

import com.hgicreate.rno.model.PciAfpTask;
import com.hgicreate.rno.repo.PciAfpTaskRepository;
import com.hgicreate.rno.service.dto.PciAfpTaskDTO;
import com.hgicreate.rno.service.mapper.PciAfpTaskMapper;
import org.springframework.stereotype.Service;

/**
 * Pci翻频任务服务的实现类，继承抽象任务服务类获得缺省实现。
 *
 * @author chen.c10
 */
@Service
public class PciAfpTaskServiceImpl extends AbstractCommonTaskService<PciAfpTask, PciAfpTaskDTO, PciAfpTaskRepository, PciAfpTaskMapper> implements PciAfpTaskService {
    public PciAfpTaskServiceImpl(PciAfpTaskRepository repository, PciAfpTaskMapper mapper) {
        super(repository, mapper);
    }
}
