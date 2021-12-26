package com.cydeer.shorturl.service.id.impl;

import com.cydeer.shorturl.service.id.ShortUrlIdGenerator;
import com.cydeer.shorturl.service.id.UrlContext;
import com.cydeer.shorturl.service.id.constant.ShortUrlIdGeneratorTypeEnum;

/**
 * @author song.z
 * @date 2021/12/25 6:02 下午
 */
public class HashShortUrlIdGenerator implements ShortUrlIdGenerator {

    @Override
    public Long generator(UrlContext urlContext) {
        return null;
    }

    @Override
    public ShortUrlIdGeneratorTypeEnum getType() {
        return ShortUrlIdGeneratorTypeEnum.HASH;
    }
}
