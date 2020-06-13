package edu.xidian.Test;

import edu.xidian.dao.UserDao;
import edu.xidian.dao.UserDaoImpl;
import edu.xidian.mapper.UserMapper;
import edu.xidian.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Demo04 {
    SqlSession session;
    @Before
    public void before() throws IOException {
        //a)读取配置文件
        InputStream is= Resources.getResourceAsStream("SqlMapConfig.xml");
        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        session=sessionFactory.openSession();
    }
    @After
    public void after(){
        session.close();
    }
    @Test
    public void test1() throws IOException{
        UserMapper userMapper=session.getMapper(UserMapper.class);
        //System.out.println(userMapper.getClass());

        //获取数据
        System.out.println(userMapper.findUserById(1));

        User user=new User("xxx","x",new Date(),"cc");
        userMapper.save(user);
        session.commit();

    }

}
