package com.example.demo.bean;

import lombok.*;

/**
 * 类说明
 *
 * @author pengnanfa
 * @date 2021-04-08 18:01
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushMessage {
    /**
     * 登录用户编号
     */
    private Integer loginUserNum;

    /**
     * 推送内容
     */
    private String content;
}
