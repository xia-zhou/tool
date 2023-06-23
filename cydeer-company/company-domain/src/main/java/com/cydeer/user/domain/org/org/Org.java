package com.cydeer.user.domain.org.org;

import lombok.Data;

/**
 * @author song.z
 * @date 2023/6/3 22:30
 */
@Data
public class Org {

    private Long tenantId;

    private String orgTypeCode;

    private String name;

    private String status;

    public void cancel() {
        this.status = OrgStatusEnum.CANCELLED.name();
    }

    public boolean isEffective() {
        return OrgStatusEnum.EFFECTIVE.name().equals(status);

    }
}
