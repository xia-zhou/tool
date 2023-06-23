package com.cydeer.user.domain.org.org.service;

import com.cydeer.user.domain.org.org.Org;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 22:34
 */
@Service
@AllArgsConstructor
public class OrgHandler {

    private final CancelOrgValidator cancelOrgValidator;

    public void updateBasic(Org org, String name, String leader) {
        updateName(org, name);
        updateLeader(org, leader);
    }

    private void updateLeader(Org org, String leader) {

    }

    private void updateName(Org org, String name) {

    }

    public void cancel(Org org, Long userId) {
        cancelOrgValidator.orgToBeCanceledShouldNotHasEmp(org);
        cancelOrgValidator.orgToBeCancelledShouldBeEffective(org);
        //org.setStatus(OrgStatusEnum.CANCELLED.name());
        // 更加的面向对象
        org.cancel();
    }
}
