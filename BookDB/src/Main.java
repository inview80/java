import DB.BookEntity;
import DB.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.currentSession();
        var t = session.beginTransaction();
        Query query = session.getNamedQuery("getBooksQuery");
        List list = query.list();
        BookEntity book;
        for (var item : list) {
            book = (BookEntity) item;
            System.out.println(book.getBookName());
            System.out.println(book.getBookTypeEntity().getBookTypeName());
        }
//        var b=session.get(BooktypeEntity.class, 1);
//        System.out.println(b.getBooks()==null);
//        System.out.println(((BookEntity)b.getBooks().toArray()[0]).getBookName());
//        var bt=new BooktypeEntity(1,"widnfi");
//        var book=new BookEntity();
//        book.setBookName("我人");
//        book.setBookTypeEntity(bt);
//        book.setPublishDate(Date.valueOf(LocalDate.now()));
//        book.setBookTypeID(bt.getBookTypeId());
//        book.setPrice(BigDecimal.TEN);
//        book.setAuthor("楞有了");
//        book.setPublishment("人阳人了");
////        session.save(bt);
//        session.save(book);
        try {
            t.commit();
        } finally {
            HibernateUtil.closeSession();
        }
    }

    private void ss() {

    }
}
