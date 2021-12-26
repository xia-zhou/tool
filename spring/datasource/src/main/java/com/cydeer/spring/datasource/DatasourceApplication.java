package com.cydeer.spring.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author song.z
 */
@SpringBootApplication
@Slf4j
public class DatasourceApplication implements CommandLineRunner {

    private final DataSource dataSource;

    private final JdbcTemplate jdbcTemplate;

    public DatasourceApplication(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatasourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("datasource:{}", dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info("connection:{}", connection.toString());
        connection.close();
        jdbcTemplate.queryForList("select * from area ").forEach(row -> log.info("row:{}", row.toString()));
    }
}
