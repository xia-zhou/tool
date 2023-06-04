package com.cydeer.user.tenantmng.gateway.impl;

import com.cydeer.user.domain.tenantmng.Tenant;
import com.cydeer.user.domain.tenantmng.gateway.TenantGateway;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 20:31
 */
@Service
public class TenantGatewayImpl implements TenantGateway {
    @Override
    public Tenant findByTenantId(Long tenantId) {
        return null;
    }
}
