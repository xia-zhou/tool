package com.cydeer.user.application.orgmng.assembler;

import com.cydeer.user.client.orgmng.OrgDTO;
import com.cydeer.user.client.orgmng.param.OrgCreateDTO;
import com.cydeer.user.client.user.UserDTO;
import com.cydeer.user.domain.org.org.Org;
import com.cydeer.user.domain.org.org.service.OrgValidatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 22:19
 */
@Service
@AllArgsConstructor
public class OrgAssembler {

    private final OrgValidatorService orgValidatorService;

    public Org assemble(OrgCreateDTO orgDTO, UserDTO user) {
        Org org = assembleOrg(orgDTO, user);
        orgValidatorService.validate(org);
        return org;
    }

    private Org assembleOrg(OrgCreateDTO orgDTO, UserDTO user) {
        return null;
    }


    public OrgDTO assemble(Org org) {
        return null;
    }
}
