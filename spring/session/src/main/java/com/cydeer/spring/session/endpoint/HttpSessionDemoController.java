package com.cydeer.spring.session.endpoint;

import com.cydeer.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author song.z
 * @date 2022/2/15 9:23 下午
 */
@RestController
public class HttpSessionDemoController {

    @GetMapping("/hello")
    public Result<String> hello(HttpSession httpSession, String name) {
        if (httpSession.getAttribute("name") != null) {
            return new Result<>(httpSession.getAttribute("name").toString());
        }
        httpSession.setAttribute("name", name);
        return new Result<>(name);
    }

}
