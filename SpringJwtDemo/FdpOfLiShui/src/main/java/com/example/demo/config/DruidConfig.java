package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Druid 配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"})//固定的包
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);
    //
    static final String MAPPER_LOCATION = "classpath*:com/gitee/sunchenbin/mybatis/actable/mapping/*/*.xml";

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.druid.maxActive}")
    private Integer maxActive;

    @Value("${spring.datasource.druid.minIdle}")
    private Integer minIdle;

    @Value("${spring.datasource.druid.initialSize}")
    private Integer initialSize;

    @Value("${spring.datasource.druid.maxWait}")
    private Long maxWait;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private Long timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private Long minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private Boolean testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private Boolean testOnReturn;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //连接池配置
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);

        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("druid configuration init fail!"+e.getMessage());
        }
        return dataSource;
    }

    @Bean(name = "transactionManager")
    //@Primary注解的作用其实就是相当于默认值
    @Primary
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory springSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.example.demo.model.*");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DruidConfig.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
