package com.gouli.authentication.controller;

import com.gouli.common.core.filter.IgnoreReposeAdvice;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * 获取公钥接口
 * @author pengnanfa
 * @date 2021/1/15 8:45
 */
@Api(tags = "获取公钥接口")
@RestController
@RequestMapping
@AllArgsConstructor
@Slf4j
public class PublicKeyController {

    private KeyPair keyPair;
    @GetMapping("/getPublicKey")
    @IgnoreReposeAdvice
    public Map<String, Object> loadPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}