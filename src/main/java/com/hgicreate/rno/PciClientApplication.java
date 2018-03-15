package com.hgicreate.rno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 程序入口类
 *
 * @author chen.c10
 */
@SpringBootApplication
@ConfigurationProperties
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableHystrix
@EnableJpaAuditing
@EnableAsync
public class PciClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PciClientApplication.class, args);
    }
}
