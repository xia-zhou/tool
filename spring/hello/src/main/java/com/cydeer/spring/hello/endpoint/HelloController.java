package com.cydeer.spring.hello.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2021/12/26 5:05 下午
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello Spring";
    }

}
