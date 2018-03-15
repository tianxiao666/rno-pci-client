package com.hgicreate.rno.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chen.c10
 */
@Data
@Entity
@Table(name = "RNO_SYS_USERS")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;
    private String fullName, email;

    private Integer enabled, defaultCity, type;

    @CreatedBy
    @Column(nullable = false)
    private String creator;
    @CreatedDate
    @Column(nullable = false)
    private Date createTime;
    @LastModifiedBy
    private String modifier;
    @LastModifiedDate
    private Date modifyTime;

    @ManyToOne
    @JoinColumn(name = "defaultCity", insertable = false, updatable = false)
    private Area area;
}
