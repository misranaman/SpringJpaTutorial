package com.dcb.spring.data.jpa.tutorial.repositories;

import com.dcb.spring.data.jpa.tutorial.entities.Course;
import com.dcb.spring.data.jpa.tutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course
                .builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course
                .builder()
                .title("Java")
                .credit(5)
                .build();


        ArrayList<Course> courses = new ArrayList<>();
        courses.add(courseDBA);
        courses.add(courseJava);

        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastName("Khan")
                //.courses(courses)
                .build();

        teacherRepository.save(teacher);

    }
}