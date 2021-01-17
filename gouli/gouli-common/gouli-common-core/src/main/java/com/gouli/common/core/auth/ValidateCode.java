package com.gouli.common.core.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pengnanfa
 * @date 2021/1/16 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateCode {
    /**
     *  验证码key
     */
    private   String codeKey;

    /**
     *  验证码Code
     */
    private   String codeValue;
}