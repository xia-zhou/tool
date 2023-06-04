package com.cydeer.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author song.z
 */
@ImportResource({"classpath*:META-INF/spring/*.xml"})
@SpringBootApplication(scanBasePackages = {"com.cydeer"})
@EnableScheduling
@EnableAsync
public class ApplicationStarter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStarter.class);

    public static void main(String[] args) {
        try {
            //初始化fork/join pool线程数
            System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
            long start = System.currentTimeMillis();
            ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class, args);
            String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
            long cost = (System.currentTimeMillis() - start);
            LOGGER.info("started in {} ms,activeProfile={}", cost, activeProfiles);
        } catch (Throwable throwable) {
            LOGGER.error("started failed", throwable);
        }
    }
}
