package com.example.tokendemo.enums;

import java.util.EnumSet;

/**
 * @Description: 描述内容
 * @Auther: pengnanfa
 * @Date: 2021/12/24 /9:59 上午
 */

public class EnumIteration {
    enum FourteenEnum {
        a, b, c, d, e, f, g, h, i, j, k, l, m, n;

        static final FourteenEnum[] VALUES;

        static {
            VALUES = values();
        }
    }

    public static void valuesEnum() {
        for (FourteenEnum value : FourteenEnum.values()) {
            System.out.println(value.ordinal());
        }
    }

    public static void enumSetEnum() {
        for (FourteenEnum value : EnumSet.allOf(FourteenEnum.class)) {
            System.out.println(value.ordinal());
        }
    }

    public static void cacheEnums() {
        for (FourteenEnum value : FourteenEnum.VALUES) {
            System.out.println(value.ordinal());
        }
    }

    public static void main(String[] args) {
        Long st = System.currentTimeMillis();
        valuesEnum();
        System.out.println("valuesEnum:" + (System.currentTimeMillis() - st));
        st = System.currentTimeMillis();
        enumSetEnum();
        System.out.println("enumSetEnum:" + (System.currentTimeMillis() - st));
        st = System.currentTimeMillis();
        cacheEnums();
        System.out.println("cacheEnums:" + (System.currentTimeMillis() - st));
    }
}
