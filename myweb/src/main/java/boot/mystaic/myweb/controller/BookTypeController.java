package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.BookType;
import boot.mystaic.myweb.service.BookTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Random;

@Slf4j
@Controller
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView getAll(){
        var mv = new ModelAndView("index");
        var tt=bookTypeService.getAll();
        log.info("1111:{}", tt);
        mv.addObject("bookTypes", tt);
        return mv;
    }

    @RequestMapping("/all")
    public ModelAndView getAll2(){
        var mv = new ModelAndView("index");
        var tt=bookTypeService.getAll();
        log.info("jjjj:{}", tt);
        mv.setView(new MappingJackson2JsonView());
        mv.addObject("bookTypes", tt);
        return mv;
    }

    @RequestMapping("/h")
    public String hello(){
        log.info("hello");
        return "hello";
    }

    @RequestMapping("/add")
    public int add(){
        Random random=new Random();
        var bt = new BookType(random.nextInt(), "jjjjj" + random.nextInt(1000));
        return bookTypeService.add(bt);
    }
}
