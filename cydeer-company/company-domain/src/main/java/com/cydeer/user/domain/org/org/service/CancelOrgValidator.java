package com.cydeer.user.domain.org.org.service;

import com.cydeer.common.util.AssertUtils;
import com.cydeer.user.domain.org.org.Org;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/7 21:45
 */
@Service
public class CancelOrgValidator {
    public void orgToBeCanceledShouldNotHasEmp(Org org) {

    }

    public void orgToBeCancelledShouldBeEffective(Org org) {
        // AssertUtils.isTrue(OrgStatusEnum.EFFECTIVE.name().equals(org.getStatus()), "该组织不是有效状态，不能删除");
        // 规避特性依赖，交给领域对象自己来实现
        AssertUtils.isTrue(org.isEffective(), "该组织不是有效状态，不能删除");
    }
}
