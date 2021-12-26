package com.cydeer.spring.jdbc.dao;

import com.cydeer.spring.jdbc.domain.Area;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author song.z
 * @date 2021/12/26 8:02 下午
 */
@Repository
public class AreaDao {

    private final JdbcTemplate jdbcTemplate;

    public AreaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Area area) {
        jdbcTemplate.update("insert into area(id,code,name) values(?,?,?)", area.getId(), area.getCode(),
                            area.getName());
    }

    public int delete(Integer id) {
        return jdbcTemplate.update("delete from area where id = ?", id);
    }

    public int update(Area area) {
        return jdbcTemplate.update("update area set code = ?,name = ? where id = ?", area.getCode(), area.getName(),
                                   area.getId());
    }

    public List<Area> list() {
        List<Area> areas = jdbcTemplate.query("select * from area", (rs, rowNum) -> Area.builder()
                .id(rs.getInt(1))
                .code(rs.getString(2))
                .name(rs.getString(3))
                .build());
        return areas;
    }

    public Area findById(Integer id) {
        // 注意该方法如果查询不到会抛出异常
        return jdbcTemplate.queryForObject("select * from area where id = ?", (rs, rowNum) -> Area.builder().id(
                rs.getInt(1)).code(rs.getString(2)).name(rs.getString(3)).build(), id);
    }
}
