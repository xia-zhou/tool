package com.cydeer.spring.mapper;

import com.cydeer.spring.domain.AgentShortUrl;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author song.z
 * @date 2022/02/13 20:52:05
 */
@Mapper
public interface AgentShortUrlMapper {
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
    int insert(AgentShortUrl row);

    /**
     * 动态字段,写入数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int insertSelective(AgentShortUrl row);

    /**
     * 根据指定主键获取一条数据库记录
     * 
     * @param id 主键ID
     * @return 查询结果
     */
    AgentShortUrl selectByPrimaryKey(Long id);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKeySelective(AgentShortUrl row);

    /**
     * 根据主键来更新符合条件的数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKey(AgentShortUrl row);
}