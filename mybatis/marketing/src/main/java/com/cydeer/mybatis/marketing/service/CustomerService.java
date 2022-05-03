package com.cydeer.mybatis.marketing.service;

import com.cydeer.mybatis.marketing.domain.Customer;
import com.cydeer.mybatis.marketing.mapper.CustomerMapper;
import com.cydeer.mybatis.marketing.support.DaoUtils;

/**
 * @author song.z
 * @date 2022/3/19 12:51 下午
 */
public class CustomerService {

    public Customer findById(Long id) {
        return DaoUtils.execute(sqlSession -> {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            return customerMapper.findById(id);
        });
    }

    public void save(String name, String phone) {
        DaoUtils.execute(sqlSession -> {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setPhone(phone);
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.save(customer);
            return null;
        });
    }
}

