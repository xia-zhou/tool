package com.cydeer.spring.web.endpoint;

import com.cydeer.spring.web.domain.Coffee;
import com.cydeer.spring.web.repository.CoffeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author song.z
 * @date 2022/1/8 8:32 下午
 */
@RestController
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/coffee/list")
    public List<Coffee> list() {
        return coffeeRepository.findAll();
    }

    @PostMapping("/coffee/save")
    public String save(@RequestBody Coffee coffee) {
        coffeeRepository.save(coffee);
        return "Success";
    }

}
