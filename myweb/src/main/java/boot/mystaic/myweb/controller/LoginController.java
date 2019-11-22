package boot.mystaic.myweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
