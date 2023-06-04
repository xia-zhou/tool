package com.cydeer.user.facade.user;

import com.cydeer.common.Result;
import com.cydeer.user.facade.user.dto.UserDTO;
import com.cydeer.user.facade.user.param.AuthParams;
import com.cydeer.user.facade.user.param.UserSpec;

/**
 * @author song.z
 * @date 2023/6/2 21:18
 */
public interface UserFacade {

    /**
     * 根据参数鉴权
     *
     * @param authParams 鉴权参数
     * @return 鉴权的结果
     */
    Result<UserDTO> auth(AuthParams authParams);

    /**
     * 根据用户ID 获取用户的基本信息
     *
     * @param userSpec 用户的查询条件
     * @return 用户信息
     */
    Result<UserDTO> findByUserSpec(UserSpec userSpec);

}
