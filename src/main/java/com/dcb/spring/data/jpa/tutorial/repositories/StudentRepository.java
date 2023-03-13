package com.dcb.spring.data.jpa.tutorial.repositories;

import com.dcb.spring.data.jpa.tutorial.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    //public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String name);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address= ?1"
            , nativeQuery = true
    )
    public Student getStudentByEmailAddressNative(String email);

    //Native Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address= :emailId"
            , nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String email);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(
            value = "UPDATE TBL_STUDENT SET first_name= ?1 WHERE email_address= ?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);

}
