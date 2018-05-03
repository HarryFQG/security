package m.itiandou.springsecurity2.dao;

import m.itiandou.springsecurity2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fengqigui
 * @description UserMapper
 * @date 2018/05/02 09:50
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户名获取用户
     * @param name
     * @return
     */
    User getUSer(@Param(value = "name") String name);

    /**
     * 获得所用的用户
     * @return
     */
    List<User> listUser();

    /**
     * 删除用户
     * @param id
     */
    void deleteUserById(@Param(value = "id")Integer id);
}
