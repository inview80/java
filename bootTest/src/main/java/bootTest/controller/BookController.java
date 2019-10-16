package bootTest.controller;

import bootTest.dao.BookServer;
import bootTest.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServer bookServer =null;

    @RequestMapping("/")
//    @ResponseBody
    public List<Book> findAll() {
        return bookServer.findAll();
    }
}
