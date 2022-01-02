package com.cydeer.spring.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
@Entity
@Table(name = "agent_short_url")
public class AgentShortUrl implements Serializable {
    /**
     * id:自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * agent_id:商户ID
     */
    @Column
    private Long agentId;

    /**
     * name:短链名称
     */
    @Column
    private String name;

    /**
     * source_url:原地址
     */
    @Column
    private String sourceUrl;

    /**
     * source_hash:原地址的hash值
     */
    @Column
    private Long sourceHash;

    /**
     * short_url:短链
     */
    @Column
    private String shortUrl;

    /**
     * invalid_time:短链失效时间
     */
    @Column
    private LocalDateTime invalidTime;

    /**
     * page_view:pv
     */
    @Column
    private Long pageView;

    /**
     * unique_view:uv
     */
    @Column
    private Long uniqueView;

    /**
     * deleted:0-未删除 1-删除
     */
    private Integer deleted;

    /**
     * gmt_created:创建时间
     */
    @Column
    private LocalDateTime gmtCreated;

    /**
     * gmt_modified:更新时间
     */
    @Column
    private LocalDateTime gmtModified;
}