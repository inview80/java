package boot.mystaic.myweb.controller;

import boot.mystaic.myweb.service.BookTypeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTypeDatabaseTest {
    @Autowired
    private BookTypeService bookTypeService;

    @Test
    public void showAll() {
        var tmp = bookTypeService.getAll();
        log.info("{}", tmp);
    }

    @Test
    public void addBookType(){
        var tmp = bookTypeService.add("jjjj");
        log.info("{}",tmp);
    }

    @Test
    public void delete(){
        var tmp = bookTypeService.deleteBookTypeByID(51);
        log.info("{}",tmp);
    }
}
