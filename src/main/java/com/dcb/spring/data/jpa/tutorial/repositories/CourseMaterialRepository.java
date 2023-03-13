package com.dcb.spring.data.jpa.tutorial.repositories;

import com.dcb.spring.data.jpa.tutorial.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
