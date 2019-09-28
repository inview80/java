package DB;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "book", catalog = "")
public class BookEntity {
    private String id;
    private String bookName;
    private int bookTypeID;
    private String publishment;
    private String author;
    private Date publishDate;
    private BigDecimal price;
    private BooktypeEntity bookTypeEntity;


    public BooktypeEntity getBookTypeEntity() {
        return bookTypeEntity;
    }

    public void setBookTypeEntity(BooktypeEntity bookType) {
        this.bookTypeEntity = bookType;
    }

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "BookType")
    public int getBookTypeID() {
        return bookTypeID;
    }

    public void setBookTypeID(int bookTypeID) {
        this.bookTypeID = bookTypeID;
    }

    @Basic
    @Column(name = "Publishment")
    public String getPublishment() {
        return publishment;
    }

    public void setPublishment(String publishment) {
        this.publishment = publishment;
    }

    @Basic
    @Column(name = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "PublishDate")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "Price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookTypeID == that.bookTypeID &&
                Objects.equals(id, that.id) &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(publishment, that.publishment) &&
                Objects.equals(author, that.author) &&
                Objects.equals(publishDate, that.publishDate) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, bookTypeID, publishment, author, publishDate, price);
    }
}
