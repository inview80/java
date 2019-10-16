package boot.mystaic.myweb.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

import java.math.BigDecimal;

@lombok.Data@NoArgsConstructor@AllArgsConstructor
public class Book {
    private String bookID;
    private String bookName;
    private short bookTypeID;
    private String publishment;
    private Date publishDate;
    private String author;
    private BigDecimal price;
    private String userCode;
    private Date borrowDate;
}
