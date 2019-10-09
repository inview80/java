package bootTest.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "book", catalog = "")
public class BookEntity {
    private String bookid;
    private String bookName;
    private short booktypeid;
    private String publishment;
    private Date publishDate;
    private String author;
    private BigDecimal price;
    private String userCode;
    private Date borrowDate;

    @Id
    @Column(name = "bookid")
    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "bookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "booktypeid")
    public short getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(short booktypeid) {
        this.booktypeid = booktypeid;
    }

    @Basic
    @Column(name = "publishment")
    public String getPublishment() {
        return publishment;
    }

    public void setPublishment(String publishment) {
        this.publishment = publishment;
    }

    @Basic
    @Column(name = "publishDate")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "userCode")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Basic
    @Column(name = "BorrowDate")
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return booktypeid == that.booktypeid &&
                Objects.equals(bookid, that.bookid) &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(publishment, that.publishment) &&
                Objects.equals(publishDate, that.publishDate) &&
                Objects.equals(author, that.author) &&
                Objects.equals(price, that.price) &&
                Objects.equals(userCode, that.userCode) &&
                Objects.equals(borrowDate, that.borrowDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookid, bookName, booktypeid, publishment, publishDate, author, price, userCode, borrowDate);
    }
}
