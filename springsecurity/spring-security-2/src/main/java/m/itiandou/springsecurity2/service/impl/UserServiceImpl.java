package m.itiandou.springsecurity2.service.impl;

import m.itiandou.springsecurity2.dao.UserMapper;
import m.itiandou.springsecurity2.entity.User;
import m.itiandou.springsecurity2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengqigui
 * @description User的 Service
 * @date 2018/05/02 10:17
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        User user = userMapper.getUSer(name);
        return user;
    }

    @Override
    public List<User> listUser() {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userMapper.getUSer(userName);
        if (user == null) {
            System.out.println("不存在这个用户和密码");
            throw new InvalidCookieException("用户名或密码错误");
        }
        System.out.println("已找到该"+userName +"用户。");
        return user;
    }


}
