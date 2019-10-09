package bootTest.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lostbook", schema = "book", catalog = "")
public class LostbookEntity {
    private String bookId;
    private String lostUserCode;
    private Date lostDate;
    private BigDecimal parFor;

    @Id
    @Column(name = "BookID")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "LostUserCode")
    public String getLostUserCode() {
        return lostUserCode;
    }

    public void setLostUserCode(String lostUserCode) {
        this.lostUserCode = lostUserCode;
    }

    @Basic
    @Column(name = "LostDate")
    public Date getLostDate() {
        return lostDate;
    }

    public void setLostDate(Date lostDate) {
        this.lostDate = lostDate;
    }

    @Basic
    @Column(name = "ParFor")
    public BigDecimal getParFor() {
        return parFor;
    }

    public void setParFor(BigDecimal parFor) {
        this.parFor = parFor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LostbookEntity that = (LostbookEntity) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(lostUserCode, that.lostUserCode) &&
                Objects.equals(lostDate, that.lostDate) &&
                Objects.equals(parFor, that.parFor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, lostUserCode, lostDate, parFor);
    }
}
