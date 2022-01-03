package com.cydeer.spring.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 表名:agent_short_url
 *
 * @author song.z
 * @date 2022/01/01 20:49:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class AgentShortUrl implements Serializable {
    /**
     * id:自增主键
     */
    @Id
    private String id;

    /**
     * agent_id:商户ID
     */
    @Indexed
    private Long agentId;

    /**
     * name:短链名称
     */
    private String name;

    /**
     * source_url:原地址
     */
    private String sourceUrl;

    /**
     * source_hash:原地址的hash值
     */
    private Long sourceHash;

    /**
     * short_url:短链
     */
    private String shortUrl;

    /**
     * invalid_time:短链失效时间
     */
    private LocalDateTime invalidTime;

    /**
     * page_view:pv
     */
    private Long pageView;

    /**
     * unique_view:uv
     */
    private Long uniqueView;

    /**
     * deleted:0-未删除 1-删除
     */
    private Integer deleted;

    /**
     * gmt_created:创建时间
     */
    private LocalDateTime gmtCreated;

    /**
     * gmt_modified:更新时间
     */
    private LocalDateTime gmtModified;
}