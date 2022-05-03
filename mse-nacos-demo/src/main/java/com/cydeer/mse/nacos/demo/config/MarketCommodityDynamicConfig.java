package com.cydeer.mse.nacos.demo.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Create Time: 2020年10月19日         </p>
 * <p>@author xiaopeng.l                </p>
 **/
@NacosPropertySource(dataId = "com.shulidata.marketing.properties", autoRefreshed = true)
@Data
@Component
public class MarketCommodityDynamicConfig {

    /**
     * 猜你喜欢商品列表数量限制
     */
    @NacosValue(value = "${commodityListLimit}", autoRefreshed = true)
    private Integer commodityListLimit;


    /**
     * 商品成本价校验黑名单
     */
    private String costPriceCheckBlackListStr;

    private List<Long> costPriceCheckBlackList;


    @NacosValue(value = "${costPriceCheckBlackListStr}", autoRefreshed = true)
    public void setCostPriceCheckBlackListStr(String costPriceCheckBlackListStr) {
        this.costPriceCheckBlackListStr = costPriceCheckBlackListStr;
        if (StringUtils.isNotEmpty(costPriceCheckBlackListStr)) {
            String[] split = costPriceCheckBlackListStr.split(",");
            costPriceCheckBlackList = Arrays.stream(split).map(Long::valueOf).collect(Collectors.toList());
        }
    }

    public List<Long> getCostPriceCheckBlackList() {
        if (CollectionUtils.isEmpty(costPriceCheckBlackList)) {
            return Collections.emptyList();
        }
        return costPriceCheckBlackList;
    }
}
