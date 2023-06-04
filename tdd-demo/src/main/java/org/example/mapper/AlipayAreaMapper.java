package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.AlipayArea;

/**
 * @author song.z
 * @date 2023/05/26 14:14:46
 */
@Mapper
public interface AlipayAreaMapper {
    /**
     * 根据主键删除数据库的记录
     * 
     * @param id 主键ID
     * @return 受影响的记录条数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新写入数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int insert(AlipayArea row);

    /**
     * 动态字段,写入数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int insertSelective(AlipayArea row);

    /**
     * 根据指定主键获取一条数据库记录
     * 
     * @param id 主键ID
     * @return 查询结果
     */
    AlipayArea selectByPrimaryKey(Integer id);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKeySelective(AlipayArea row);

    /**
     * 根据主键来更新符合条件的数据库记录
     * 
     * @param row 对应的数据记录
     * @return 受影响的记录条数
     */
    int updateByPrimaryKey(AlipayArea row);
}