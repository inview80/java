package boot.mystaic.myweb.service;

import boot.mystaic.myweb.mapper.BookMapper;
import boot.mystaic.myweb.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAll(){
        return bookMapper.getAll();
    }

    public int add(Book book) {
        return bookMapper.add(book);
    }

    public List<Book> findBooks(Book book) {
        return bookMapper.findBooks(book);
    }
}
