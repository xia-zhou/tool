package com.cydeer.user.domain.org.org.service;

import com.cydeer.common.util.AssertUtils;
import com.cydeer.user.domain.org.org.Org;
import com.cydeer.user.domain.tenantmng.gateway.TenantGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 21:01
 */
@Service
@AllArgsConstructor
public class OrgValidatorService {

    private final TenantGateway tenantGateway;

    public void validate(Org org) {
        AssertUtils.isNotNull(tenantGateway.findByTenantId(org.getTenantId()), "租户ID对应的租户不存在");
        AssertUtils.isNotBlank(org.getOrgTypeCode(), "组织类别不能为空");
        AssertUtils.isFalse("ENTP".equals(org.getOrgTypeCode()), "企业必须是什么时候创建的");
    }
}
