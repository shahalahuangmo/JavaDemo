package com.gouli.authentication.swagger;

import com.gouli.common.core.swagger.Swagger2ConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置类
 * @author pengnanfa
 * @date 2021/1/15 16:09
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
    * admin-server
    *
    * @return
    */
    @Bean(name = "authentication-server")
     public Docket docket(Environment environment) {
        // 设置要配置的Swagger环境
        // 通过environment.acceptsProfiles判断是否处在自己设定的环境中
        Profiles profiles = Profiles.of("dev", "test");
        String moduleName = "authentication-server";
        String[] basePackage ={ "com.gouli.authentication.controller"};
        Docket docket = Swagger2ConfigUtils.docket(moduleName,environment.acceptsProfiles(profiles),basePackage);
        return docket;
     }

}
