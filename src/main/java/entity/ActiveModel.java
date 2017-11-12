package entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class ActiveModel {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public void save() throws SQLException {
        Session session = null;
        try {
            session = getSession();

            session.beginTransaction();
            session.save(this);
            session.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }
}
