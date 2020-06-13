package edu.xidian.Test;

import edu.xidian.model.User;
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
import java.util.Date;
import java.util.List;

public class Demo02 {
    /*
    抽取公共部分
     */
    SqlSession sqlSession;
    @Before
    public void before() throws IOException {
        System.out.println("before....获取session");
        //a)读取配置文件
        InputStream is= Resources.getResourceAsStream("SqlMapConfig.xml");
        //b)通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        //c)通过SqlSessionFactory创建SqlSession
        sqlSession = sessionFactory.openSession();
    }
    @After
    public void after(){
        System.out.println("after....关闭session");
        //关闭SqlSession。
        sqlSession.close();
    }
    //查询
    @Test
    public void test1() throws IOException {
        //查询一条结果
        User user = sqlSession.selectOne("findUserById", 10);
        System.out.println(user);
        //查询多条结果
        List<User> users = sqlSession.selectList("findUserByName", "张");//模糊查询
        System.out.println(users);

    }
    //插入
    @Test
    public void test2() throws IOException {
        User user=new User("wml","1",new Date(),"河南鹿邑");

        sqlSession.insert("insertUser",user);

        sqlSession.commit();
    }

    //删除
    @Test
    public void test3() throws IOException {
        sqlSession.delete("deleteUser",27);
        sqlSession.commit();
    }

    //更新
    @Test
    public void test4() throws IOException {
        User user=new User();
        user.setId(28);
        user.setAddress("深圳");
        user.setSex("2");
        sqlSession.update("updateUser",user);
        sqlSession.commit();
    }

    //插入后，往模型里设置id
    @Test
    public void test5() throws IOException {
        User user=new User("wwww","1",new Date(),"河南商丘");

        sqlSession.insert("insertUser2",user);//返回用户id

        sqlSession.commit();
        System.out.println("用户的id:"+user.getId());
    }
}
