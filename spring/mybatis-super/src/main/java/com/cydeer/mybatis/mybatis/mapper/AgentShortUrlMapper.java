package com.cydeer.mybatis.mybatis.mapper;

import com.cydeer.mybatis.mybatis.domain.AgentShortUrl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author song.z
 * @date 2021/12/31 22:59:48
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

    /**
     * 获取所有记录
     *
     * @return 短链
     */
    @Select("select * from agent_short_url")
    List<AgentShortUrl> listAll();
}