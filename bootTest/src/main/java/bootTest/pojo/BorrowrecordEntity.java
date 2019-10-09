package bootTest.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "borrowrecord", schema = "book", catalog = "")
public class BorrowrecordEntity {
    private String bookId;
    private String userCode;
    private Date borrowDate;
    private Date returnDate;
    private BigDecimal overTimeCost;

    @Id
    @Column(name = "BookID")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "UserCode")
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

    @Basic
    @Column(name = "ReturnDate")
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "OverTimeCost")
    public BigDecimal getOverTimeCost() {
        return overTimeCost;
    }

    public void setOverTimeCost(BigDecimal overTimeCost) {
        this.overTimeCost = overTimeCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowrecordEntity that = (BorrowrecordEntity) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(userCode, that.userCode) &&
                Objects.equals(borrowDate, that.borrowDate) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(overTimeCost, that.overTimeCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, userCode, borrowDate, returnDate, overTimeCost);
    }
}
