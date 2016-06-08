package com.higedrum.springboot.rest.sample;

import lombok.Data;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * アプリケーションのConfigクラスです
 *
 * Created by koji on 2016/06/08.
 */
@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;
    DataSource dataSource;

    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    @Bean(destroyMethod = "close")
    DataSource realDataSource() {
        DataSourceBuilder factory = DataSourceBuilder.create(this.dataSourceProperties.getClassLoader()).url(this.dataSourceProperties.getUrl()).username(this.dataSourceProperties.getUsername()).password(this.dataSourceProperties.getPassword());
        this.dataSource = factory.build();
        return this.dataSource;
    }

    @Primary
    @Bean
    DataSource dataSource() {
        return new Log4jdbcProxyDataSource(this.dataSource);
    }

}
