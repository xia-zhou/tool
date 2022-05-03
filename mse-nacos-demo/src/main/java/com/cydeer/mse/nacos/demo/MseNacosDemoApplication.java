package com.cydeer.mse.nacos.demo;

import com.cydeer.mse.nacos.demo.config.MarketCommodityDynamicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author song.z
 */
@SpringBootApplication
public class MseNacosDemoApplication implements CommandLineRunner {

    @Value("${cydeer.name}")
    private String name;
    @Autowired
    private Environment environment;

    @Autowired
    private MarketCommodityDynamicConfig marketCommodityDynamicConfig;

    public static void main(String[] args) {
        SpringApplication.run(MseNacosDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(marketCommodityDynamicConfig.getCommodityListLimit());
        System.out.println(name);
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println(name);
        }

    }
}
