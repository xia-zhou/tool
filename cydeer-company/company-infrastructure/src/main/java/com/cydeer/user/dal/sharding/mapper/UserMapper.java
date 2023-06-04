package com.cydeer.user.dal.sharding.mapper;

import com.cydeer.user.dal.sharding.dataobject.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author song.z
 * @date 2023/06/02 20:26:53
 */
@Mapper
public interface UserMapper {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id 主键ID
     * @return 受影响的记录条数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新写入数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int insert(User row);

    /**
     * 动态字段,写入数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int insertSelective(User row);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param id 主键ID
     * @return 查询结果
     */
    User selectByPrimaryKey(Long id);

    User findByUid(@Param("uid") String uid);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKey(User row);
}