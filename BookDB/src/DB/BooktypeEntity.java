package DB;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "booktype", schema = "book", catalog = "")
public class BooktypeEntity {
    private int bookTypeId;
    private String bookTypeName;
//    private Set books = new HashSet<BookEntity>();

    public BooktypeEntity(int id,String widnfi) {
        this.bookTypeId=id;
        this.bookTypeName=widnfi;
    }

    public BooktypeEntity() {
    }

//    public Set getBooks() {
//        return books;
//    }
//
//    public void setBooks(Set books) {
//        this.books = books;
//    }

    @Id
    @Column(name = "BookTypeID")
    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    @Basic
    @Column(name = "BookTypeName")
    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooktypeEntity that = (BooktypeEntity) o;
        return bookTypeId == that.bookTypeId &&
                Objects.equals(bookTypeName, that.bookTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookTypeId, bookTypeName);
    }
}
