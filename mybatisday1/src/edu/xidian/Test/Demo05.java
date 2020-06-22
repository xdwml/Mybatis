package edu.xidian.Test;

import edu.xidian.mapper.UserMapper;
import edu.xidian.model.User;
import edu.xidian.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo05 {
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

        //通过模型的包装类来查询用户
        UserQueryVO query=new UserQueryVO();
        User user=new User();
        user.setId(1);
        query.setUser(user);

        List<User> list = userMapper.findUserBuUserQueryVo(query);
        System.out.println(list);
    }

}
