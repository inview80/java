package DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
//    private static Log log = (Log) LoggerFactory.logger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
//            log.error("创建SessionFactory失败。", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

     static final ThreadLocal<Session> thread_var = new ThreadLocal<>();

    public static Session currentSession() {
        var s = thread_var.get();
        if (s == null) {
            s = sessionFactory.openSession();
            thread_var.set(s);
        }
        return s;
    }

    public static void closeSession() {
        var s = thread_var.get();
        if (s != null) s.close();
        thread_var.set(null);
    }

    private HibernateUtil() {
    }
}
