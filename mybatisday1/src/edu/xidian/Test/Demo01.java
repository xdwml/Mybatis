package edu.xidian.Test;

import edu.xidian.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo01 {
    //查询
    @Test
    public void test1() throws IOException {
        //a)读取配置文件
        String resource="SqlMapConfig.xml";
        InputStream is= Resources.getResourceAsStream(resource);
        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);

        //c)通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        //d)调用SqlSession的操作数据库方法
        //查询一条结果
        User user = sqlSession.selectOne("findUserById", 10);
        System.out.println(user);
        //查询多条结果
        List<User> users = sqlSession.selectList("findUserByName", "张");//模糊查询
        System.out.println(users);

        //关闭SqlSession。
        sqlSession.close();
    }


}
