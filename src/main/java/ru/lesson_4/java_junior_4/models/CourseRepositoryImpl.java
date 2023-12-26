package ru.lesson_4.java_junior_4.models;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.lesson_4.java_junior_4.Course;
import ru.lesson_4.java_junior_4.dataBaseConnection.HibernateUtil;


import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    @Override
    public void add(Course course) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Course retrievedcourse) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(retrievedcourse);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course retrievedcourse) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(retrievedcourse);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course getById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            return session.get(Course.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        List<Course> result = null;
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Query<Course> query = session.createQuery("FROM " + Course.class.getSimpleName(), Course.class);
            List<Course> courses = query.list();
            session.getTransaction().commit();
            result = courses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}