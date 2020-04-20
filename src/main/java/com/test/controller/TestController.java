package com.test.controller;

import com.test.dao.UserMapper;
import com.test.domain.User;
import com.test.domain.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestController {

    public static void testMapper() throws IOException {
        String resource = "mybatis.xml";
        // 读取配置文件
        Reader reader = Resources.getResourceAsReader(resource);
        // 获取会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession openSession = sqlSessionFactory.openSession();
        // 调用api
        //新增
        User userPa = new User();
        userPa.setId(1);
        userPa.setUsername("zhengym-1");
        userPa.setPassword("123");
        UserMapper mapper = openSession.getMapper(UserMapper.class);
        int reuslt = mapper.insert(userPa);//返回保存数据记录数
        System.out.println(reuslt);
//        openSession.commit();//提交事务，对于数据库的保存，删除操作，需要提交事务，否则该操作还没持久化到数据库中


        //查询
       /* UserExample selectEx = new UserExample();
        UserExample.Criteria criteria = selectEx.createCriteria();
        UserExample.Criteria criteria1 = criteria.andUsernameLike("%zheng%");
        List<User> users = mapper.selectByExample(selectEx);
        for (User user:users) {
            System.out.println(user.getUsername());
        }

        //更新
        UserExample updateEx = new UserExample();
        User user = mapper.selectByPrimaryKey(4);
        user.setPassword("9999");
        int upRes = mapper.updateByPrimaryKey(user);//返回更新记录数
        System.out.println(upRes);
        openSession.commit();//提交事务


        //删除
        UserExample delEx = new UserExample();
        delEx.createCriteria().andIdGreaterThanOrEqualTo(1);//主键大于等于1的记录数
        mapper.deleteByExample(delEx);
        openSession.commit();//提交事务

//        openSession.rollback();//事务回滚*/
        openSession.close();//关闭会话

    }

    public static void main(String[] args) throws IOException {
        testMapper();
    }
}
