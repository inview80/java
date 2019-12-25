package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.BookType;
import boot.mystaic.myweb.service.BookTypeService;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/booktype")
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("/getTypeList")
    @ResponseBody
    public List<BookType> getAll() {
        var tt = bookTypeService.getAll();
        log.info("1111:{}", tt);
        return tt;
    }


    @RequestMapping("/h")
    public String hello() {
        return "page/booktype/showBookType";
    }

    @GetMapping("add")
    public String add() {
        return "/booktype/addBookType";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String add(@RequestBody String bt) {
        log.info("{}", bt);
        if (StrUtil.isBlank(bt)) {
            if (bookTypeService.add(bt) > 0) {
                log.info("写入数据库成功。");
                return bt;
            }
        } else {
            log.info("图书类型名称不能空");
        }
        log.info("写入数据库失败");
        return null;
    }

}
