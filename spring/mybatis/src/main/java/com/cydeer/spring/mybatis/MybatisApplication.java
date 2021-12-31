package com.cydeer.spring.mybatis;

import com.cydeer.spring.mybatis.domain.Area;
import com.cydeer.spring.mybatis.mapper.AreaMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author song.z
 */
@SpringBootApplication
@MapperScan("com.cydeer.spring.mybatis.mapper")
@Slf4j
public class MybatisApplication implements CommandLineRunner {

    private final AreaMapper areaMapper;

    public MybatisApplication(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Area area = Area.builder().code("101").name("浙江").codeName("你好啊").build();
        areaMapper.save(area);
        log.info("area :{}", area);

        area = areaMapper.findById(area.getId());

        log.info("area:{}", area);
    }
}
