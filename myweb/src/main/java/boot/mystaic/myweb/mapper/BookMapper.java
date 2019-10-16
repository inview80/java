package boot.mystaic.myweb.mapper;

import boot.mystaic.myweb.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    List<Book> getAll();
    int add(Book book);

    List<Book> findBooks(Book book);
}
