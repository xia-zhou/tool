package com.cydeer.spring.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author song.z
 */
@SpringBootApplication
@Slf4j
public class DatasourceApplication implements CommandLineRunner {

    private final DataSource dataSource;

    public DatasourceApplication(DataSource dataSource) {
        this.dataSource = dataSource;
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
    }
}
