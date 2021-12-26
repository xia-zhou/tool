package com.cydeer.shorturl.service.id;

import com.cydeer.shorturl.service.id.constant.ShortUrlIdGeneratorTypeEnum;

/**
 * @author song.z
 * @date 2021/12/25 5:59 下午
 */
public interface ShortUrlIdGenerator {

    /**
     * 根据原始url信息获取到短链ID
     *
     * @param urlContext 原始url信息
     * @return 短链url的唯一标识
     */
    Long generator(UrlContext urlContext);


    /**
     * 短链唯一ID生成算法类型
     *
     * @return ID生成算法类型
     */
    ShortUrlIdGeneratorTypeEnum getType();

}
