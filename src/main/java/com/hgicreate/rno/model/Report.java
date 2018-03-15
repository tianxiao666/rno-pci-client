package com.hgicreate.rno.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chen.c10
 */
@Data
@Entity
@Table(name = "RNO_LTE_JOB_REPORT")
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long jobId;
    private String stage;
    private LocalDateTime begTime;
    private LocalDateTime endTime;
    private String state;
    @Column(nullable = false)
    @Enumerated
    private ReportType reportType;
    private String attMsg;

    @PrePersist
    public void prePersist() {
        if (reportType == null) {
            reportType = ReportType.Business;
        }
    }
}
