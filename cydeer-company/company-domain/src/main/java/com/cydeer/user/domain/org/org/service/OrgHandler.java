package com.cydeer.user.domain.org.org.service;

import com.cydeer.user.domain.org.org.Org;
import org.springframework.stereotype.Service;

/**
 * @author song.z
 * @date 2023/6/4 22:34
 */
@Service
public class OrgHandler {
    public void updateBasic(Org org, String name, String leader) {
        updateName(org, name);
        updateLeader(org, leader);
    }

    private void updateLeader(Org org, String leader) {

    }

    private void updateName(Org org, String name) {

    }
}
