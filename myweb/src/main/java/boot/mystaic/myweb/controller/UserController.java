package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.User;
import boot.mystaic.myweb.service.UserService;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
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
        log.info("user:{}",user);
        if
        var pwdEncoder = new Pbkdf2PasswordEncoder(secret);
        user.setPassword(pwdEncoder.encode(user.getPassword()));
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
