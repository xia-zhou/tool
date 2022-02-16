package com.cydeer.spring.health.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author song.z
 * @date 2022/2/16 10:31 下午
 */
@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        Health health = Health.up().withDetail("数据库", "还可以的").withDetail("其他", "也还行").build();
        return health;
    }
}
