package boot.mystaic.myweb.mapper;

import boot.mystaic.myweb.pojo.Book;
import boot.mystaic.myweb.sqlProvider.BookSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    @Select("select * from book where 1=1")
    List<Book> getAll();

    @InsertProvider(type = BookSqlProvider.class, method = "addBook")
    int add(@Param("book") Book book);

    @SelectProvider(type = BookSqlProvider.class, method = "findBooks")
    List<Book> findBooks(@Param("book") Book book);

    @Select("select * from book where bookID=#{bookID}")
    Book findBookByID(String bookID);

    @Delete(("delete from book where bookID=#{bookID}"))
    int deleteBookByID(String bookID);
}
