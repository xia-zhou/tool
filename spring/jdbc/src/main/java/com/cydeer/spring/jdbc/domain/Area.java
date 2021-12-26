package com.cydeer.spring.jdbc.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author song.z
 * @date 2021/12/26 8:01 下午
 */
@Data
@Builder
public class Area {

    private Integer id;

    private String code;

    private String name;

}
