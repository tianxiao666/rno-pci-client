package com.hgicreate.rno.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 天线方位角作业对象
 *
 * @author chen.c10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RNO_LTE_AZIMUTH_EVAL_JOB")
public class AzimuthEvaluationTask extends AbstractTask {
    @Id
    private Long jobId;
    @Column(nullable = false)
    private Long areaId;
    private LocalDate begMeaTime, endMeaTime;
    private LocalDateTime createTime, modTime;
    private String dlFileName, finishState, evalType;
    private String cells;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DbRowStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Job job;

    @OneToOne
    @JoinColumn(name = "areaId", insertable = false, updatable = false)
    private Area area;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        createTime = now;
        modTime = now;
        finishState = "排队中";
        status = DbRowStatus.N;
    }

    @PreUpdate
    public void preUpdate() {
        modTime = LocalDateTime.now();
    }
}
