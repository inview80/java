package boot.mystaic.myweb.sqlProvider;

import boot.mystaic.myweb.pojo.Book;
import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.jdbc.SQL;

public class BookSqlProvider {
    public String addBook(Book book) {
        return new SQL(){{
            INSERT_INTO("book");
            VALUES("bookID", book.getBookID());
            VALUES("bookName", book.getBookName());
        }}.toString();
    }

    public String findBooks(Book book) {
        return new SQL(){{
            SELECT("*");
            FROM("book");
            if (StrUtil.isNotBlank(book.getBookName())) {
                WHERE("bookName like \"%\"#{book.bookName}\"%\"");
            }
            if (StrUtil.isNotBlank(book.getPublishment())) {
                WHERE("publishment like \"%\"#{book.publishment}\"%\"");
            }
        }}.toString();
    }
}
