package edu.xidian.mapper;

import edu.xidian.model.User;
import edu.xidian.vo.UserQueryVO;

import java.util.List;

public interface UserMapper {
    /**
     *
     * @param user
     * @return 受影响的行数
     */
    public int save(User user);

    public  User findUserById(int id);

    public List<User> findUserBuUserQueryVo(UserQueryVO vo);
}
