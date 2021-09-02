package com.itheima.pinda.common;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.itheima.pinda.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author Zhang
 * @date 9/2/2021 2:03 PM
 * @description
 */
public class CustomIdGenerator implements IdentifierGenerator {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

    @Autowired
    private IdWorker idWorker;

    @Override
    public Long nextId(Object entity) {
        return idWorker.nextId();
    }
}
