package com.cydeer.mybatis.marketing.mapper;

import com.cydeer.mybatis.marketing.domain.Customer;

/**
 * @author song.z
 * @date 2022/3/19 12:45 下午
 */
public interface CustomerMapper {

    /**
     * @param id
     * @return
     */
    Customer findById(Long id);

    /**
     * @param customer
     */
    void save(Customer customer);

}
