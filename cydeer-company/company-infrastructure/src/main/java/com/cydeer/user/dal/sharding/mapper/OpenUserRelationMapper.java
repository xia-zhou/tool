package com.cydeer.user.dal.sharding.mapper;

import com.cydeer.user.dal.sharding.dataobject.OpenUserRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author song.z
 * @date 2023/06/02 20:40:46
 */
@Mapper
public interface OpenUserRelationMapper {
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
    int insert(OpenUserRelation row);

    /**
     * 动态字段,写入数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int insertSelective(OpenUserRelation row);

    /**
     * 根据指定主键获取一条数据库记录
     *
     * @param id 主键ID
     * @return 查询结果
     */
    OpenUserRelation selectByPrimaryKey(Long id);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKeySelective(OpenUserRelation row);

    /**
     * 根据主键来更新符合条件的数据库记录
     *
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKey(OpenUserRelation row);

    OpenUserRelation findByOpenId(String openId);
}