package com.cydeer.user.client.user;

import com.cydeer.boot.starter.web.user.IUser;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @author song.z
 * @date 2023/6/4 19:39
 */
@Data
public class UserDTO implements IUser {

    private Long userId;

    private String openId;

    private String appId;

    private String authAppId;

    private String nickName;

    private String avatar;

    @Override
    public String getKey() {
        return Optional.ofNullable(userId).map(Object::toString).orElse(StringUtils.EMPTY);
    }
}
