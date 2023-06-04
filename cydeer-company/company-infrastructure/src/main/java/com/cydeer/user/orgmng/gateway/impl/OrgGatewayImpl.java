package com.cydeer.user.orgmng.gateway.impl;

import com.cydeer.user.domain.org.org.Org;
import com.cydeer.user.domain.org.org.OrgGateway;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 20:24
 */
@Service
public class OrgGatewayImpl implements OrgGateway {
    @Override
    public Org save(Org org) {
        return null;
    }

    @Override
    public Org findByOrgId(Long orgId) {
        return null;
    }

    @Override
    public void updateOrg(Org org) {
        UserDT userDT = new UserDT(123L, "123", "auu", "2123");
        userDT.userId();
    }
}
