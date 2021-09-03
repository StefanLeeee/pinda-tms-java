package com.rex.rexmybatisplusdemo;

import com.rex.rexmybatisplusdemo.mapper.UserMapper;
import com.rex.rexmybatisplusdemo.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RexMybatisplusdemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(x-> System.out.println(x));
        userList.forEach(System.out::println);


    }

}
