package com.itheima.pinda.common;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.itheima.pinda.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Enbing
 * @create 2021-09-01 10:04 PM
 * @Description Id生成器
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }

    @Autowired
    private IdWorker idWorker;

    @Override
    public Number nextId(Object entity) {
        return idWorker.nextId();
    }
}
