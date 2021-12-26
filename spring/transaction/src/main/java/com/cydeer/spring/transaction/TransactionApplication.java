package com.cydeer.spring.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author song.z
 */
@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class TransactionApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      
    }
}
