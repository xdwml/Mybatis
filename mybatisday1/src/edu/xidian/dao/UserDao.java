package edu.xidian.dao;

import edu.xidian.model.User;

public interface UserDao {
    /**
     * 保存用户
     * @param user
     */
    public void save(User user);


    /**
     * 查找用户
     * @param id
     * @return
     */
    public  User findUserById(int id);
}
