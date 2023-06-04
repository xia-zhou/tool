package com.cydeer.user.dal.sharding.dataobject;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表名:openid_user_relation_000
 * 
 * @author song.z
 * @date 2023/06/02 20:40:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenUserRelation {
    /**
     * id:主键
     */
    private Long id;

    /**
     * gmt_created:创建时间
     */
    private LocalDateTime gmtCreated;

    /**
     * gmt_modified:更新时间
     */
    private LocalDateTime gmtModified;

    /**
     * open_id:三方openid
     */
    private String openId;

    /**
     * platform_id:平台标识
     */
    private String platformId;

    /**
     * user_id:内部用户ID
     */
    private Long userId;

    /**
     * union_id:三方unionid
     */
    private String unionId;

    /**
     * app_id:应用id或授权appid
     */
    private String appId;

    /**
     * sl_union_id:数立unionid
     */
    private Long slUnionId;
}