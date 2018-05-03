package m.itiandou.springsecurity2.dao;

import m.itiandou.springsecurity2.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author fengqigui
 * @description
 * @date 2018/05/02 10:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUSer() throws Exception {

        User admin = userMapper.getUSer("admin");
        System.out.println(admin);
    }

    @Test
    public void listUser() throws Exception {
    }

}