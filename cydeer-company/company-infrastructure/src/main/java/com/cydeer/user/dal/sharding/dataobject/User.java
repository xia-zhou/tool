package com.cydeer.user.dal.sharding.dataobject;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表名:user_001
 * 
 * @author song.z
 * @date 2023/06/02 20:26:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     */
    private Long id;

    /**
     */
    private LocalDateTime gmtCreated;

    /**
     */
    private LocalDateTime gmtModified;

    /**
     * user_id:内部用户ID
     */
    private Long userId;

    /**
     * uid:外部平台用户账号
     */
    private String uid;

    /**
     * platform_id:平台标识
     */
    private String platformId;

    /**
     * name:用户名
     */
    private String name;

    /**
     * gender:用户性别
     */
    private Integer gender;

    /**
     * phone:用户手机号
     */
    private String phone;

    /**
     * avatar:用户头像文件地址
     */
    private String avatar;

    /**
     * status:用户状态
     */
    private Integer status;

    /**
     * deleted:是否删除
     */
    private Integer deleted;

    /**
     * source:来源
     */
    private String source;
}