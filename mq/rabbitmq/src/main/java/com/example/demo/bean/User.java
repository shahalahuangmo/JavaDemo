package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-07 11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 8142836626401616290L;
    private Integer id;
    private String name;
    private String password;
}

