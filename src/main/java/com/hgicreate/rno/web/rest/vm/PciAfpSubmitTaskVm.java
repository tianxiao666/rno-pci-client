package com.hgicreate.rno.web.rest.vm;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区域PCI翻频方案任务条件
 *
 * @author li.tf
 * @date 2018-01-12 14:47:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PciAfpSubmitTaskVm extends AbstractSubmitTaskVm {
    private String account;
    private long cityId;
    private String taskName;
    private String description;
    private String mode;
    private String optimizeCells;
    private String config;
    private String cellm3rinterfercoef;
    private String scellm6rinterfercoef;
    private String cellm30rinterfercoef;
    private String topncelllist;
    private String increasetopncelllist;
    private String beforenstrongcelltab;
    private String convermethod1targetval;
    private String convermethod2targetval;
    private String convermethod2scoren;
    private String dislimit;
}
