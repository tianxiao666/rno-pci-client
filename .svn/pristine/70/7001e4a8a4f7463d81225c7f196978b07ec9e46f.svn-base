package com.hgicreate.rno.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * pci优化作业对象
 *
 * @author chen.c10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "RNO_LTE_PCI_JOB")
public class PciAfpTask extends AbstractTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(insertable = false, updatable = false)
    private Long jobId;
    @Column(nullable = false)
    private Long areaId;
    private Date createTime, modTime;
    private String dlFileName, finishState, optimizeCells;
    @Column(name = "is_check_ncell")
    private Boolean checkNCell;
    @Column(name = "ks_corr_val")
    private Double ks = 0.02;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DbRowStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobId")
    private Job job;

    @OneToOne
    @JoinColumn(name = "areaId", insertable = false, updatable = false)
    private Area area;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        createTime = now;
        modTime = now;
        finishState = "排队中";
        status = DbRowStatus.N;
    }

    @PreUpdate
    public void preUpdate() {
        modTime = new Date();
    }
}
