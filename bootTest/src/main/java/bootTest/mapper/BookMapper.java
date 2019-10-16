package bootTest.mapper;

import bootTest.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    List<Book> findAll();
}
