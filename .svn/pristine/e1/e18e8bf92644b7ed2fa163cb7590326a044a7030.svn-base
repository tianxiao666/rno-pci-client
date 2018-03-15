package com.hgicreate.rno.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author chen.c10
 */
@Data
@Entity
@Table(name = "RNO_LTE_JOB")
@EntityListeners(AuditingEntityListener.class)
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private JobType type;
    private String description;
    private Long areaCode;
    @Enumerated(EnumType.STRING)
    private JobStatus runningStatus;
    private String finishState;
    private LocalDateTime launchTime, completeTime;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DbRowStatus status;
    @CreatedBy
    private String creator;
    @CreatedDate
    private LocalDateTime createTime;
    @LastModifiedBy
    private String modifier;
    @LastModifiedDate
    private LocalDateTime modifyTime;

    @OneToOne
    @JoinColumn(name = "areaCode", referencedColumnName = "code", insertable = false, updatable = false)
    private Area area;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "job")
    private List<JobParam> params;

    @PrePersist
    public void prePersist() {
        runningStatus = JobStatus.Waiting;
        finishState = "排队中";
        status = DbRowStatus.N;
    }

    public boolean canStop() {
        return JobStatus.Waiting.equals(runningStatus) || JobStatus.Running.equals(runningStatus);
    }
}
