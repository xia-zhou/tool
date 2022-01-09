package com.cydeer.spring.web.repository;

import com.cydeer.spring.web.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author song.z
 * @date 2022/1/8 8:32 下午
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {}
