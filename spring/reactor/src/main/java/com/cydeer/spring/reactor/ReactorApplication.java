package com.cydeer.spring.reactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

/**
 * @author song.z
 */
@SpringBootApplication
@Slf4j
public class ReactorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux.range(1, 10)
                .doOnRequest(n -> log.info("doOnRequest:{}", n))
                .doOnNext(i -> log.info("i:{}", i))
                .doOnComplete(() -> log.error("doOnComplete"))
                .map(i -> {
                    log.info("map:{}", i);
                    return i + 10;
                }).subscribe();
    }
}
