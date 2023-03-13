package com.dcb.spring.data.jpa.tutorial.repositories;

import com.dcb.spring.data.jpa.tutorial.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Page<Course> findByTitleContaining(
            String title,
            Pageable pageRequest);
}
