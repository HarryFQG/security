package m.itiandou.springsecurity2.service;

import m.itiandou.springsecurity2.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author fengqigui
 * @description
 * @date 2018/05/02 10:15
 */
public interface UserService extends UserDetailsService {

    /**
     * 通过用户姓名获得用户信息
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 获得所用的用户
     * @return
     */
    List<User> listUser();

    /**
     * 删除用户
     * @param id
     */
    void deleteUserById(Integer id);
}
