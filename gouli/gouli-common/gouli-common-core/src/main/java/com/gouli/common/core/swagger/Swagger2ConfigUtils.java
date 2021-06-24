package com.gouli.common.core.swagger;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Swagger2 公共配置工具类
 *
 * @author pengnanfa
 * @date 2021/1/15 21:58
 */
public class Swagger2ConfigUtils {

    /**
     * 配置模块
     *
     * @param moduleName  模块名称
     * @param isShow  是否开启Swagger2
     * @param basePackage 基础包(多个,使用 ; 分隔)
     * @return
     */
    public static Docket docket(String moduleName,boolean isShow, String... basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(moduleName))
                //.groupName(groupName) 这里暂时不用分组，主要是与Gateway集成比较复杂
                //通过flag判断是否开启
                .enable(isShow)
                .select()
                /**
                 * apis():指定扫描的接口
                 *  RequestHandlerSelectors:配置要扫描接口的方式
                 *       basePackage:指定要扫描的包
                 *       any:扫面全部
                 *       none:不扫描
                 *       withClassAnnotation:扫描类上的注解(参数是类上注解的class对象)
                 *       withMethodAnnotation:扫描方法上的注解(参数是方法上的注解的class对象)
                 */
                .apis(basePackage(basePackage))
                /**
                 * paths():过滤路径
                 *  PathSelectors:配置过滤的路径
                 *      any:过滤全部路径
                 *      none:不过滤路径
                 *      ant:过滤指定路径:按照按照Spring的AntPathMatcher提供的match方法进行匹配
                 *      regex:过滤指定路径:按照String的matches方法进行匹配
                 */
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }


    /**
     * Predicate that matches RequestHandler with given base package name for the class of the handler method.
     * This predicate includes all request handlers matching the provided basePackage
     * 声明基础包
     * @param basePackage - 基础包路径
     * @return this
     */
    public static Predicate<RequestHandler> basePackage(final String... basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);

    }

    /**
     * 校验基础包
     * 处理包路径配置规则,支持多路径扫描匹配以逗号隔开
     *
     * @param basePackage 扫描包路径
     * @return Function
     */
    private static Function<Class<?>, Boolean> handlerPackage(final String... basePackage) {
        return input -> {
            for (String strPackage : basePackage) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };

    }

    /**
     * 检验基础包实例
     * @param requestHandler RequestHandler请求处理类
     * @return Optional
     */
    @SuppressWarnings("deprecation")
    private static Optional<? extends Class<?>> declaringClass(RequestHandler requestHandler) {
        return Optional.fromNullable(requestHandler.declaringClass());
    }

    /**
     * 配置在线文档的基本信息
     *
     * @return
     */
    private static ApiInfo apiInfo(String moduleName) {
        return new ApiInfoBuilder()
                .title(moduleName)
                .contact(new Contact("Powered By PKPM", "https://www.cnblogs.com/cao-lei", null))
                .termsOfServiceUrl("https://www.cnblogs.com/cao-lei/")
                .version("V1.0")
                .build();
    }

    /**
     *  用于描述我们的API如何保护 基本认证，OAuth2，...）
     * @return
     */
    private static List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }

    /**
     * 安全上下文
     * @return
     */
    private static List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()
        );
    }

    private static List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }
}
