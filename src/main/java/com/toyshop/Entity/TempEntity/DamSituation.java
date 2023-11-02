package com.toyshop.Entity.TempEntity;

import lombok.Data;

@Data
public class DamSituation {
    private int value;
    private String name;

    @Override
    public String toString() {
        return "{value:" + value + ",name:" + "'" + name + "'" + "}";
    }
}
