package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.User;
import boot.mystaic.myweb.service.UserService;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${system.user.password.secret}")
    private String secret = null;

    @RequestMapping("/u")
    @ResponseBody
    private void addUser(User user) {
        log.info("secret code:{}",secret);
        var pwdEncoder = new Pbkdf2PasswordEncoder(secret);
        Random random=new Random();
        user.setUserCode(String.valueOf(random.nextInt()));
        user.setCreateDate(DateTime.now().offset(DateField.SECOND,random.nextInt(200_000)));
        String tmp = new String(new char[]{(char) ('a' + random.nextInt(26)), (char) ('a' + random.nextInt(26)), (char) ('a' + random.nextInt(26)), (char) ('a' + random.nextInt(26))}) + random.nextInt(100);
        user.setUserName(tmp);
        user.setPassword(pwdEncoder.encode(tmp));
        boolean isOk = userService.addUser(user);
        if (isOk) {
            log.info("增加用户成功：{}", user);
        } else {
            log.error("增加用户失败。");
        }
    }

    @RequestMapping("/")
    @ResponseBody
    private List<User> getAllUser() {
        return userService.getAll();
    }
}
