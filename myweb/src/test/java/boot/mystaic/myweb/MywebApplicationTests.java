package boot.mystaic.myweb;

import boot.mystaic.myweb.pojo.User;
import boot.mystaic.myweb.secret.PowerEnum;
import boot.mystaic.myweb.service.UserService;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MywebApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        var user = new User();
        var pwdEncoder = new Pbkdf2PasswordEncoder("inview");
        Random random = new Random();
        user.setUserCode(String.valueOf(random.nextInt()));
        user.setCreateDate(DateTime.now().offset(DateField.SECOND, random.nextInt(200_000)));
        String tmp = new String(new char[]{(char) ('a' + random.nextInt(26)), (char) ('a' + random.nextInt(26)),
                (char) ('a' + random.nextInt(26)), (char) ('a' + random.nextInt(26))}) + random.nextInt(100);
        user.setUserName(tmp);
        user.setPassword(pwdEncoder.encode(tmp));
        user.setPowerDetails(PowerEnum.ADMINISTER);
        boolean isOk = userService.addUser(user);
        if (isOk) {
            log.info("增加用户成功：{}", user);
        } else {
            log.error("增加用户失败。");
        }

    }

}
