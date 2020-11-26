package com.example.demo.config.security;

import com.example.demo.config.security.filter.AdminAuthenticationProcessingFilter;
import com.example.demo.config.security.filter.MyAuthenticationFilter;
import com.example.demo.config.security.jwtfilter.JWTAuthenticationFilter;
import com.example.demo.config.security.jwtfilter.JWTAuthorizationFilter;
import com.example.demo.config.security.login.AdminAuthenticationEntryPoint;
import com.example.demo.config.security.url.UrlAccessDecisionManager;
import com.example.demo.config.security.url.UrlAccessDeniedHandler;
import com.example.demo.config.security.url.UrlFilterInvocationSecurityMetadataSource;
import com.example.demo.system.mapper.basemapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.annotation.Resource;

/**
 * 核心配置类
 */
@Configuration
@EnableWebSecurity
// 至于为什么要配置这个，嘿嘿，卖个关子
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    //url权限相关 - ========================================================================================
    /**
     * 获取访问url所需要的角色信息
     */
    private final UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;
    /**
     * 认证权限处理 - 将上面所获得角色权限与当前登录用户的角色做对比，如果包含其中一个角色即可正常访问
     */
    private final UrlAccessDecisionManager urlAccessDecisionManager;
    /**
     * 自定义访问无权限接口时403响应内容
     */
    private final UrlAccessDeniedHandler urlAccessDeniedHandler;

    @Resource
    private UserMapper userMapper;

    //url权限相关 - ========================================================================================

    public SecurityConfig(UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource,
                          UrlAccessDeniedHandler urlAccessDeniedHandler,
                          UrlAccessDecisionManager urlAccessDecisionManager) {
        this.urlFilterInvocationSecurityMetadataSource = urlFilterInvocationSecurityMetadataSource;
        this.urlAccessDeniedHandler = urlAccessDeniedHandler;
        this.urlAccessDecisionManager = urlAccessDecisionManager;
    }


    /**
     * 权限配置
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected  void configure(HttpSecurity httpSecurity) throws  Exception
    {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry
                = httpSecurity.antMatcher("/**").authorizeRequests(); //需要验证了的用户才能访问
        // 禁用CSRF 开启跨域
        httpSecurity.csrf().disable().cors();
         // JWT验证Filter
        httpSecurity .addFilter(new JWTAuthenticationFilter(authenticationManager(),userMapper));
        // JWT鉴权Filter
        httpSecurity .addFilter(new JWTAuthorizationFilter(authenticationManager()));
        // url权限认证处理
        expressionInterceptUrlRegistry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        });

        // 不需要session
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 标识只能在 服务器本地ip[127.0.0.1或localhost] 访问 `/home` 这个接口，其他ip地址无法访问
        expressionInterceptUrlRegistry.antMatchers("/**").hasIpAddress("127.0.0.1");
        // 允许匿名的url - 可理解为放行接口 - 除配置文件忽略url以外，其它所有请求都需经过认证和授权
        /*for (String url : myProperties.getAuth().getIgnoreUrls()) {
            expressionInterceptUrlRegistry.antMatchers(url).permitAll();
        }*/

        //        registry.antMatchers("/**").access("hasAuthority('admin')");
        // OPTIONS(选项)：查找适用于一个特定网址资源的通讯选择。 在不需执行具体的涉及数据传输的动作情况下， 允许客户端来确定与资源相关的选项以及 / 或者要求， 或是一个服务器的性能
        expressionInterceptUrlRegistry.antMatchers(HttpMethod.OPTIONS, "/**").denyAll();
        // 自动登录 - cookie储存方式
        expressionInterceptUrlRegistry.and().rememberMe();
        // 其余所有请求都需要认证
        expressionInterceptUrlRegistry.anyRequest().authenticated();
        // 防止iframe 造成跨域
        expressionInterceptUrlRegistry.and().headers().frameOptions().disable();
    }

    /**
     * 忽略拦截url或静态资源文件夹 - web.ignoring(): 会直接过滤该url - 将不会经过Spring Security过滤器链
     * http.permitAll(): 不会绕开springsecurity验证，相当于是允许该路径通过
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.GET,
                "/favicon.ico",
                "/*.html",
                "/**/*.css",
                "/**/*.js");
    }
}
