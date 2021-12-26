package com.cydeer.spring.transaction.endpoint;

import com.cydeer.spring.transaction.service.TransactionTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2021/12/26 10:47 下午
 */
@RestController
@Slf4j
public class TransactionController {

    @Autowired
    private TransactionTestService transactiontestService;

    @GetMapping("/transaction")
    public String get() {
        try {
            transactiontestService.insertWithRequireNew();
        } catch (Exception e) {
            log.error("get.insertWithRequireNew.error");
        }
        transactiontestService.query("30000");
        transactiontestService.query("40000");

        try {
            transactiontestService.insertWithNested();
        } catch (Exception e) {
            log.error("get.insertWithNested.error");
        }
        transactiontestService.query("50000");
        transactiontestService.query("60000");
        return "success";
    }

}
