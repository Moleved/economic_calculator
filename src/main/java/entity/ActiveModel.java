package entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    /* Public section */

    public void save() {
        Session session = null;
        try {
            session = getSession();

            session.beginTransaction();
            session.save(this);
            session.getTransaction().commit();

        } finally {
            if(session != null && session.isOpen()) session.close();
        }
    }

    public Object getById(int id) {
        Session session = null;
        Object object = null;
        try {
            session = getSession();
            object = session.load(this.getClass(), id);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return object;
    }

    public List<ActiveModel> getAll() {
        Session session = null;
        List<ActiveModel> list = new ArrayList<ActiveModel>();
        try {
            session = getSession();
            list = session.createQuery("from " + this.getClass().getSimpleName()).list();
        } catch(SessionException ex) {
            System.out.println(ex.getStackTrace());
        }

        return list;
    }

    public Object getLast() {
        Session session = null;
        Object object = null;
        try {
            session = getSession();
            object = session.createQuery("FROM " + this.getClass().getSimpleName() + " ORDER BY id DESC").setMaxResults(1).list().get(0);
        } catch (SessionException se) {
            System.out.println(se.getStackTrace());
        }

        return object;
    }

    /* Private section */

    private Method getMethodByName(String methodName, Session session) {
        try {
            return session.getClass().getMethod(methodName, Object.class);
        } catch(NoSuchMethodException exception) {
            System.out.println(exception);
            return null;
        }
    }
}
