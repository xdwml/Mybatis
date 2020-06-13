package edu.xidian.mapper;

import edu.xidian.model.User;

public interface UserMapper {
    /**
     *
     * @param user
     * @return 受影响的行数
     */
    public int save(User user);

    public  User findUserById(int id);
}
