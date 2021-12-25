package com.example.tokendemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class TokendemoApplicationTests {

    @Test
    void contextLoads() {

        String st = "无";

        Long value = 2000l;

        Integer s1 = 12;
        if ("无".equals(st) || Integer.parseInt(st) == 0) {
            s1 = 1;
        }

    }

}
