package com.cydeer.user.client.orgmng.param;

import lombok.Data;

/**
 * @author song.z
 * @date 2023/6/4 22:17
 */
@Data
public class OrgBasicUpdateDTO {

    private Long orgId;

    private String name;

    private String leader;

}
