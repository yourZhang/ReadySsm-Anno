import com.zys.config.SpringConfig;
import com.zys.pojo.User;
import com.zys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @program: ssm
 * @description: 测试
 * @author: xiaozhang6666
 * @create: 2020-09-15 09:18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class TestUnit {
    @Autowired
    UserService userService;

    @Test
    public void test01() {
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    public void test02() {
        //测试事务
        User user = new User(null, "习大大1", "男", new Date(), "天安门");
        Integer integer = userService.saveUser(user);
        System.out.println(integer);
    }
}
