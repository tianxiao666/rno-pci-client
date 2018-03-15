package com.hgicreate.rno.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chen.c10
 */
@Data
@Entity
@Table(name = "RNO_SYS_AREA")
@Cacheable
public class Area implements Serializable {
    @Id
    private Long id;
    @Column(nullable = false)
    private Long code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long parentCode;
    @Enumerated
    private AreaLevel level;
    @Column(name = "longitude")
    private Double lon;
    @Column(name = "latitude")
    private Double lat;
}
