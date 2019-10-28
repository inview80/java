package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.BookType;
import boot.mystaic.myweb.pojo.User;
import boot.mystaic.myweb.service.BookTypeService;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("/")
    @ResponseBody
    public List<BookType> getAll(){
        var tt=bookTypeService.getAll();
        log.info("1111:{}", tt);
        return tt;
    }


    @RequestMapping("/h")
    public String hello(){
        log.info("page/booktype/showBookType");
        return "page/booktype/showBookType";
    }

    @GetMapping("add")
    public String add(){
        return "/booktype/addBookType";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public BookType add(@RequestBody BookType bt){
        log.info("{}",bt);
        if (bt.getBookTypeID() != 0 && bt.getBookTypeName() != null && !bt.getBookTypeName().isBlank()) {
            if (bookTypeService.add(bt)>0) {
                log.info("成功");
                return bt;
            }
        }
        log.info("null");
        return new BookType(0, "");
    }
}
