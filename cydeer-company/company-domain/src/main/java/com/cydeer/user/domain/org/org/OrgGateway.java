package com.cydeer.user.domain.org.org;

/**
 * @author song.z
 * @date 2023/6/3 22:42
 */
public interface OrgGateway {
    Org save(Org org);

    Org findByOrgId(Long orgId);

    void updateOrg(Org org);
}
