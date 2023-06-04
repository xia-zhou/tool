package com.cydeer.user.support;

import com.alibaba.fastjson.JSON;
import com.cydeer.boot.starter.web.user.IUser;
import com.cydeer.boot.starter.web.user.IUserProcessor;
import com.cydeer.boot.starter.web.user.UserContext;
import com.cydeer.user.client.user.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 18:58
 */
@Service
public class UserProcessor implements IUserProcessor {
    @Override
    public IUser getFromRequest(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        return JSON.parseObject(token, UserDTO.class);
    }
}
