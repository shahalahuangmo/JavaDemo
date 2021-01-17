package com.gouli.gateway.swagger;

import com.gouli.gateway.constant.GateWayConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取具体服务 apidocs
 * @author pengnanfa
 * @date 2021/1/15 16:52
 */
@Component
@Primary
@AllArgsConstructor
@Slf4j
public class GateWaySwaggerResourceProvider implements SwaggerResourcesProvider {

    public  static final String API_URI = "/v2/api-docs";
    public  static final String VERSION = "2.0";
    public  static final String API_GROUP = "?group=";
    public  static final String PATH = "Path";
    public  static final String ZERO = "0";

    private final RouteLocator routeLocator;
    private final GatewayProperties gatewayProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        // 取出gateway的route
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        // 结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(predicateDefinition -> (PATH).equalsIgnoreCase(predicateDefinition.getName()))
                        .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
                                predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + ZERO)
                                        .replace(GateWayConstants.URL_FILTER, API_URI)))));
        return resources;
    }

    /**
     *
     * @param name 服务名称
     * @param location 服务的 Swagger地址路径
     * @return
     */
    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(VERSION);
        return swaggerResource;
    }

    /**
     *
     * @param name 服务名称
     * @param location 服务的 Swagger地址路径
     * @param groupName 服务的 Swagger 分组名称
     * @return
     */
    private SwaggerResource swaggerResource(String name, String location, String groupName) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location + API_GROUP + groupName);
        swaggerResource.setSwaggerVersion(VERSION);
        return swaggerResource;
    }

}
