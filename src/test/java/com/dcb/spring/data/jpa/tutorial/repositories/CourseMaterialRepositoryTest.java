package com.dcb.spring.data.jpa.tutorial.repositories;

import com.dcb.spring.data.jpa.tutorial.entities.Course;
import com.dcb.spring.data.jpa.tutorial.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("Dot Net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dailycodebuffer.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {

        List<CourseMaterial> courseMaterialList = repository.findAll();

        System.out.println("course material:" + courseMaterialList);

    }
}