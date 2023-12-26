package ru.lesson_4.java_junior_4;

import ru.lesson_4.java_junior_4.Course;
import ru.lesson_4.java_junior_4.createDB.CreateDB;
import ru.lesson_4.java_junior_4.models.CourseRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3308/schoolDB";
        new CreateDB(url, "schoolDB", "course");

        Course course = new Course("developer", 12);
        CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();

        // добавляем в базу
        courseRepository.add(course);

        // обновляем данные
        course.setDuration(500);
        courseRepository.update(course);

        // получаем данные по id
        Course retrivedCourse = courseRepository.getById(2);
        System.out.println("Object with id 2: " + retrivedCourse);

        //получаем все данные
        List<Course> arrayCourse = courseRepository.getAll();
        arrayCourse.forEach(System.out::println);
    }

}