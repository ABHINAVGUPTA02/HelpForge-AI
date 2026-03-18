package com.theSilentBell.HelpForge.db.utils;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile({"dev", "stage", "prod"})
public class DataSourceConfig {

    @Bean(name="postgresql")
    @ConfigurationProperties(prefix="spring.datasource.schema1")
    public DataSource postgresqlDataSource() {
        return (HikariDataSource) DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
}
