package bootTest.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "booktype", schema = "book", catalog = "")
public class BooktypeEntity {
    private Short booktypeid;
    private String booktypeName;

    @Basic
    @Column(name = "booktypeid")
    public Short getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(Short booktypeid) {
        this.booktypeid = booktypeid;
    }

    @Id
    @Column(name = "booktypeName")
    public String getBooktypeName() {
        return booktypeName;
    }

    public void setBooktypeName(String booktypeName) {
        this.booktypeName = booktypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooktypeEntity that = (BooktypeEntity) o;
        return Objects.equals(booktypeid, that.booktypeid) &&
                Objects.equals(booktypeName, that.booktypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booktypeid, booktypeName);
    }
}
