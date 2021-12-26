package com.cydeer.spring.transaction.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author song.z
 * @date 2021/12/26 10:22 下午
 */
@Service
@Slf4j
public class TransactionTestService {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TransactionTestService transactionTestService;


    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void insert() {
        jdbcTemplate.update("insert into area(code,name) values(?,?)", "30000", "苏州");
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertWithRequireNew() {
        jdbcTemplate.update("insert into area(code,name) values(?,?)", "40000", "南京");
        try {
            transactionTestService.insert();
        } catch (Exception e) {
            log.error("insert error");
        }
        throw new RuntimeException("insertWithRequireNew");
    }

    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.NESTED)
    public void insertNested() {
        jdbcTemplate.update("insert into area(code,name) values(?,?)", "50000", "北京");
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertWithNested() {
        jdbcTemplate.update("insert into area(code,name) values(?,?)", "60000", "河南");
        try {
            transactionTestService.insertNested();
        } catch (Exception e) {
            log.error("insertNested error", e);
        }
        throw new RuntimeException("insertWithNested");
    }

    public void query(String code) {
        log.info("code:{},count: {}", code,
                 jdbcTemplate.queryForObject("select count(*) from area where code = ?", Integer.class, code));
    }


    public void delete(String code) {
        jdbcTemplate.update("delete from area where code = ?", code);
    }


}
