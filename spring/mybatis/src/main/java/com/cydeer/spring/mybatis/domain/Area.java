package com.cydeer.spring.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author song.z
 * @date 2021/12/31 4:14 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    private Integer id;

    private String code;

    private String name;

    private String codeName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
