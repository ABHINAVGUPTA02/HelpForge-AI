package com.theSilentBell.HelpForge.db.utils;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile({"local", "dev", "stage", "prod"})
public class DataSourceConfig {

    @Bean(name="postgresql")
    @ConfigurationProperties(prefix="spring.data.postgresql")
    public DataSource postgresqlDataSource() {
        return (HikariDataSource) DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
}
