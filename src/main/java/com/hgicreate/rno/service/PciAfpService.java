package com.hgicreate.rno.service;

import com.hgicreate.rno.web.rest.vm.PciAfpSubmitTaskVm;

/**
 * @author chen.c10
 */
public interface PciAfpService {
    /**
     * 保存一个pci翻频任务
     *
     * @param vm 视图模型
     * @return 是否保存成功
     */
    boolean savePciAfpJob(PciAfpSubmitTaskVm vm);
}
