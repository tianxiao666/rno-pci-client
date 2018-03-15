package com.hgicreate.rno.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chen.c10
 */
@Data
@Entity
@Table(name = "RNO_LTE_JOB_PARAM")
@ToString(exclude = "job")
@NoArgsConstructor
public class JobParam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(insertable = false, updatable = false)
    private Long jobId;
    @Enumerated(EnumType.STRING)
    private ParamType type;
    private String code, value;

    @ManyToOne
    @JoinColumn(name = "jobId", referencedColumnName = "id")
    private Job job;

    public enum ParamType {
        // 阈值和参数
        THRESHOLD, PROPERTY, TEST
    }

    private JobParam(ParamType type, String code, String value, Job job) {
        this.type = type;
        this.code = code;
        this.value = value;
        this.job = job;
    }

    public static JobParam of(ParamType type, String code, String value, Job job) {
        return new JobParam(type, code, value, job);
    }
}