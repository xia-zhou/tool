package com.cydeer.user.application.orgmng;

import com.cydeer.common.util.AssertUtils;
import com.cydeer.user.application.orgmng.assembler.OrgAssembler;
import com.cydeer.user.client.orgmng.OrgDTO;
import com.cydeer.user.client.orgmng.param.OrgBasicUpdateDTO;
import com.cydeer.user.client.orgmng.param.OrgCreateDTO;
import com.cydeer.user.client.user.UserDTO;
import com.cydeer.user.domain.org.org.Org;
import com.cydeer.user.domain.org.org.OrgGateway;
import com.cydeer.user.domain.org.org.service.OrgHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/3 22:35
 */
@Service
@AllArgsConstructor
public class OrgService {

    private final OrgGateway orgGateway;

    private final OrgAssembler orgAssembler;

    private final OrgHandler orgHandler;

    public OrgDTO addOrg(OrgCreateDTO orgDTO, UserDTO user) {
        Org org = orgAssembler.assemble(orgDTO, user);
        org = orgGateway.save(org);
        return orgAssembler.assemble(org);
    }

    public OrgDTO updateBasic(OrgBasicUpdateDTO orgBasicUpdateDTO, UserDTO user) {
        Org org = orgGateway.findByOrgId(orgBasicUpdateDTO.getOrgId());
        AssertUtils.isNotNull(org, "组织不存在");
        orgHandler.updateBasic(org, orgBasicUpdateDTO.getName(), orgBasicUpdateDTO.getLeader());
        orgGateway.updateOrg(org);
        return null;
    }
}
