package com.cydeer.user.orgmng;

import com.cydeer.boot.starter.web.user.UserContext;
import com.cydeer.common.Result;
import com.cydeer.user.application.orgmng.OrgService;
import com.cydeer.user.client.orgmng.OrgDTO;
import com.cydeer.user.client.orgmng.param.OrgBasicUpdateDTO;
import com.cydeer.user.client.orgmng.param.OrgCreateDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2023/6/3 22:38
 */
@RestController
@AllArgsConstructor
public class OrgController {


    private final OrgService orgService;


    @PostMapping("/org/add")
    public Result<OrgDTO> addOrg(@RequestBody OrgCreateDTO orgCreateDTO) {
        return new Result<>(orgService.addOrg(orgCreateDTO, UserContext.get()));
    }

    @PostMapping("/org/add")
    public Result<OrgDTO> updateBasic(@RequestBody OrgBasicUpdateDTO orgBasicUpdateDTO) {
        return new Result<>(orgService.updateBasic(orgBasicUpdateDTO, UserContext.get()));
    }
}
