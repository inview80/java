package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.pojo.Book;
import boot.mystaic.myweb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {
    @Autowired
    private BookService bookService;

    @Test
    public void getLists() {
        var tmp = bookService.findBooks(new Book());
        log.info("{}",tmp);
    }

}
