package com.hgicreate.rno.model;

/**
 * @author chen.c10
 */

public enum JobStatus {
    // 等待运行，已启动，正在运行，失败，成功，停止
    Waiting("Waiting"), Launched("Launched"), Running("Running"), Fail("Fail"), Succeeded("Succeeded"), Stopped("Stopped");

    String desc;

    JobStatus(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
