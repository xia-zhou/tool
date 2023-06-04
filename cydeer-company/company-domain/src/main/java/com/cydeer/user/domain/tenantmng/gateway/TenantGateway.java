package com.cydeer.user.domain.tenantmng.gateway;

import com.cydeer.user.domain.tenantmng.Tenant;

/**
 * @author song.z
 * @date 2023/6/3 22:43
 */
public interface TenantGateway {
    Tenant findByTenantId(Long tenantId);
}
