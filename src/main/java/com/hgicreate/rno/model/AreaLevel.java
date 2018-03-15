package com.hgicreate.rno.model;

/**
 * @author chen.c10
 */

public enum AreaLevel {
    // 根据jpa的规则枚举类型在数据库中以从0开始的数字表示。
    // 第一个位置放上国家暂时用不上，只是占用0这个位置，与现有数据表中省的级别是1刚好对应。
    // 采用行政规划的五级区划，省级，地区级，县级，乡级，村级
    Country("国家"), Province("省级"), Prefecture("地区级"), County("县级"), Township("乡级"), Village("村级");
    private String name;

    AreaLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
