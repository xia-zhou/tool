package com.cydeer.spring.mongo;

import com.cydeer.spring.mongo.domain.AgentShortUrl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author song.z
 */
@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    private final MongoTemplate mongoTemplate;

    public MongoApplication(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.save(AgentShortUrl.builder().agentId(1L).shortUrl("121").build());
    }
}
