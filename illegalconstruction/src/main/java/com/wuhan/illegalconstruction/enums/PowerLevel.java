package com.wuhan.illegalconstruction.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum PowerLevel implements IEnum<Integer> {
    Street(1,"街道"),
    Region(2,"区"),
    City(3,"市"),
    System(4,"系统管理员");

    private int value;
    private String desc;

    PowerLevel(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
