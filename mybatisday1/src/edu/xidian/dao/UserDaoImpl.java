package edu.xidian.dao;

import edu.xidian.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory ssf;

    public UserDaoImpl(SqlSessionFactory ssf) {
        this.ssf = ssf;
    }

    @Override
    public void save(User user) {
        //获取session
        SqlSession sqlSession=ssf.openSession();
        //插入数据
        sqlSession.insert("insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findUserById(int id) {
        //获取session
        SqlSession sqlSession=ssf.openSession();
        //插入数据
        User user = sqlSession.selectOne("findUserById", id);

        sqlSession.close();
        return user;
    }
}
