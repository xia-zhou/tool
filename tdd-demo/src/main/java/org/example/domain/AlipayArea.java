package org.example.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表名:alipay_area
 * 
 * @author song.z
 * @date 2023/05/26 14:14:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlipayArea implements Serializable {
    /**
     */
    private Integer id;

    /**
     * code:行政编码
     */
    private String code;

    /**
     * name:名称
     */
    private String name;

    /**
     * parent_code:所属行政区
     */
    private String parentCode;

    /**
     * type:地址级别
     */
    private Integer type;

    /**
     * city_code_type:城市码类型,默认商家券招商活动城市码
     */
    private String cityCodeType;

    private static final long serialVersionUID = 1L;
}