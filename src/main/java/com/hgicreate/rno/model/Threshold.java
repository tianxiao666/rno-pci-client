package com.hgicreate.rno.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chen.c10
 */
@Data
@Entity
@Table(name = "RNO_LTE_THRESHOLD")
public class Threshold implements Serializable {
    @Id
    private Long id;
    private Long order;
    @Enumerated(EnumType.STRING)
    private ModuleType moduleType;
    private String code, description, defaultValue, scopeDesc, conditionGroup;

    public enum ModuleType {
        // 模块名
        STRUCTANA, LTEINTERFERCALC, TEST
    }
}