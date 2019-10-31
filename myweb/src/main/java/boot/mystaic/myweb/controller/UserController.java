package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.User;
import boot.mystaic.myweb.secret.PowerEnum;
import boot.mystaic.myweb.service.UserService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<Boolean, Object> addUser(User user) {
        var result = new HashMap<Boolean, Object>();
        log.info("user:{}", user);
        if (cn.hutool.core.util.StrUtil.isBlank(user.getUserName())) {
            result.put(false, "用户名不能为空！");
            return result;
        }
        if (StrUtil.isBlank(user.getPassword())) {
            result.put(false, "密码不能为空！");
            return result;
        }
        if (user.getPowerDetails() == null) user.setPowerDetails(PowerEnum.GENERAL);
        var pwdEncoder = new Pbkdf2PasswordEncoder(secret);
        user.setPassword(pwdEncoder.encode(user.getPassword()));
        if (userService.addUser(user)) {
            result.put(true, user);
            log.info("增加用户成功：{}", user);
        } else {
            result.put(false, "写入数据库失败！");
            log.error("增加用户失败。");
        }
        return result;
    }

    @RequestMapping("/")
    @ResponseBody
    private List<User> getAllUser() {
        return userService.getAll();
    }

    @RequestMapping("/allUser")
    private String getUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "page/user/showAllUser::table_refresh";
    }

    @RequestMapping("/a")
    private String aa(){
        return "/page/user/showAllUser";
    }
}
