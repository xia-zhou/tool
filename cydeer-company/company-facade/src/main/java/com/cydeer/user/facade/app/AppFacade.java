package com.cydeer.user.facade.app;

import com.cydeer.common.Result;
import com.cydeer.user.facade.app.dto.AppDTO;
import com.cydeer.user.facade.app.dto.AppDetailDTO;
import com.cydeer.user.facade.app.param.AppSaveParams;
import com.cydeer.user.facade.app.param.AppSpec;


/**
 * @author song.z
 * @date 2023/6/2 21:18
 */
public interface AppFacade {

    /**
     * 保存app
     *
     * @param appSaveParams 参数
     * @return 保存的结果
     */
    Result<String> saveApp(AppSaveParams appSaveParams);

    /**
     * 获取单个应用的信息
     *
     * @param appSpec 查询参数，主要是根据id查询
     * @return 应用详情
     */
    Result<AppDetailDTO> findByAppSpec(AppSpec appSpec);

    /**
     * 根据条件获取列表
     *
     * @param appSpec 参数
     * @return 应用基本信息
     */
    Result<AppDTO> listByAppSpec(AppSpec appSpec);

}
