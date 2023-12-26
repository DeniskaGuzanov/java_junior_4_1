package ru.lesson_4.java_junior_4.dataBaseConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.lesson_4.java_junior_4.Course;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory =  new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Course.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}