package entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    /* Public section */

    public void save() {
        try {
            sensitiveDBRequest("save");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void update() {
        try {
            sensitiveDBRequest("update");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void delete() {
        try {
            sensitiveDBRequest("delete");
        } catch (SQLException ex) {
            System.out.println(ex);
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

    /* Private section */

    private void sensitiveDBRequest(String method) throws SQLException {
        Session session = null;
        try {
            session = getSession();
            Method callableMethod = getMethodByName(method, session);

            session.beginTransaction();
            callableMethod.invoke(session, this);
            session.getTransaction().commit();

        } catch (InvocationTargetException ex) {
            System.out.println(ex);
        } catch (IllegalAccessException ex) {
            System.out.println(ex);
        } finally {
            if(session != null && session.isOpen()) session.close();
        }
    }

    private Method getMethodByName(String methodName, Session session) {
        try {
            return session.getClass().getMethod(methodName, Object.class);
        } catch(NoSuchMethodException exception) {
            System.out.println(exception);
            return null;
        }
    }
}
