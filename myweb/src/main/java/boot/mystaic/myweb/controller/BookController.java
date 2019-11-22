package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.Book;
import boot.mystaic.myweb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String getAll() {
        return "page/book/showBook";
    }

    @RequestMapping("/a")
    public String getAll2(){return "page/book/show2";}

    @RequestMapping("/list2")
    @ResponseBody
    public List<Book> list2(){
        return bookService.findBooks(new Book());
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Book> list(@RequestParam(value = "bookName",required = false)String bookName, @RequestParam(value = "publishment",required = false)String publishment){
        var book=new Book();
//        Optional.ofNullable(bookName).ifPresent(val -> book.setBookName(val.trim()));
//        Optional.ofNullable(publishment).ifPresent(val -> book.setPublishment(val.trim()));
//        log.info("{}",book);
        List<Book> tmp=bookService.findBooks(book);
        log.info("{}", tmp);
        return tmp;
    }

    @ResponseBody
    @RequestMapping("/add")
    public int add() {
        Random random = new Random();
        var bk = new boot.mystaic.myweb.pojo.Book(random.nextInt() + "", "jjjj", (short) random.nextInt(1000), "llll"
                , new Date(11), "llll", BigDecimal.ONE, "3322jj", new Date(444));
        return bookService.add(bk);
    }
}
