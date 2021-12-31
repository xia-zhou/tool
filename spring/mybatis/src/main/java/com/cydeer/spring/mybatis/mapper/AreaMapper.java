package com.cydeer.spring.mybatis.mapper;

import com.cydeer.spring.mybatis.domain.Area;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author song.z
 * @date 2021/12/31 4:16 下午
 */
@Mapper
@Repository
public interface AreaMapper {

    /**
     * 创建地区
     *
     * @param area 地区
     * @return 影响的行数
     */
    @Insert("insert into area(code,name,code_name,create_time,update_time)values(#{code},#{name},#{codeName},now(),now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Area area);

    /**
     * 查找地区
     *
     * @param id id
     * @return 地区
     */
    @Select("select * from area where id = #{id}")
    Area findById(Integer id);

}
