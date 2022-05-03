package com.cydeer.mybatis.marketing;

import com.cydeer.mybatis.marketing.service.CustomerService;
import org.junit.Before;
import org.junit.Test;

/**
 * @author song.z
 * @date 2022/3/19 12:54 下午
 */

public class CustomerServiceTest {

    private static CustomerService customerService;

    @Before
    public void init() {
        customerService = new CustomerService();
    }

    @Test
    public void testSave() {
        customerService.save("张松", "18768125668");
    }


}
