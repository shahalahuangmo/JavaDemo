package com.example.demo.config.security;

import com.example.demo.config.security.filter.AdminAuthenticationProcessingFilter;
import com.example.demo.config.security.filter.MyAuthenticationFilter;
import com.example.demo.config.security.jwtfilter.JWTAuthenticationFilter;
import com.example.demo.config.security.jwtfilter.JWTAuthorizationFilter;
import com.example.demo.config.security.login.AdminAuthenticationEntryPoint;
import com.example.demo.config.security.url.UrlAccessDecisionManager;
import com.example.demo.config.security.url.UrlAccessDeniedHandler;
import com.example.demo.config.security.url.UrlFilterInvocationSecurityMetadataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * 核心配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    /**
     * 访问鉴权 - 认证token、签名...
     */
    private final MyAuthenticationFilter myAuthenticationFilter;
    /**
     * 访问权限认证异常处理
     */
    private final AdminAuthenticationEntryPoint adminAuthenticationEntryPoint;
    /**
     * 用户密码校验过滤器
     */
    private final AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter;

    // 上面是登录认证相关

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

    //url权限相关 - ========================================================================================

    //JWT鉴权相关 - ========================================================================================
    /**
     * JWT验证Filter
     */
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    /**
     * JWT鉴权Filter
     */
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    //JWT鉴权相关 - ========================================================================================

    public SecurityConfig(MyAuthenticationFilter myAuthenticationFilter,
                          AdminAuthenticationEntryPoint adminAuthenticationEntryPoint,
                          AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter,
                          UrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource,
                          UrlAccessDeniedHandler urlAccessDeniedHandler,
                          UrlAccessDecisionManager urlAccessDecisionManager,
                          JWTAuthenticationFilter jwtAuthenticationFilter,
                          JWTAuthorizationFilter jwtAuthorizationFilter) {
        this.myAuthenticationFilter = myAuthenticationFilter;
        this.adminAuthenticationEntryPoint = adminAuthenticationEntryPoint;
        this.adminAuthenticationProcessingFilter = adminAuthenticationProcessingFilter;
        this.urlFilterInvocationSecurityMetadataSource = urlFilterInvocationSecurityMetadataSource;
        this.urlAccessDeniedHandler = urlAccessDeniedHandler;
        this.urlAccessDecisionManager = urlAccessDecisionManager;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
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
                // 需要验证了的用户才能访问
                = httpSecurity.antMatcher("/**").authorizeRequests();

        // 禁用CSRF 开启跨域
        httpSecurity.csrf().disable().cors();
        // 未登录认证异常
        httpSecurity.exceptionHandling().authenticationEntryPoint(adminAuthenticationEntryPoint);
        // 登录过后访问无权限的接口时自定义403响应内容
        httpSecurity.exceptionHandling().accessDeniedHandler(urlAccessDeniedHandler);
        // JWT验证Filter
        httpSecurity .addFilter(jwtAuthenticationFilter);
        // JWT鉴权Filter
        httpSecurity .addFilter(jwtAuthorizationFilter);
        // 不需要session
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // url权限认证处理
        expressionInterceptUrlRegistry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        });
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
