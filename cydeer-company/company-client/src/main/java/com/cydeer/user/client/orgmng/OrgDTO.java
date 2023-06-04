package com.cydeer.user.client.orgmng;

import lombok.Data;

/**
 * @author song.z
 * @date 2023/6/4 18:53
 */
@Data
public class OrgDTO {

    private Long tenantId;

    private String orgTypeCode;

    private String name;

    private String status;

}
