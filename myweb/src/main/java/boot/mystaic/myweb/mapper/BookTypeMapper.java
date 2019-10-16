package boot.mystaic.myweb.mapper;

import boot.mystaic.myweb.pojo.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTypeMapper {
    List<BookType> getAll();
    int add( BookType bookType);
}
