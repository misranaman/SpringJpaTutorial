package com.dcb.spring.data.jpa.tutorial.repositories;

import com.dcb.spring.data.jpa.tutorial.entities.Guardian;
import com.dcb.spring.data.jpa.tutorial.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("sumitra@gmail.com")
                .firstName("Sumitra")
                .lastName("Lokhande")
                //.guardianName("Den Parker")
                //.guardianEmail("dp@gmail.com")
                //.guardianMobile("9996661212")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("student list " + studentList);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Den Parker")
                .mobile("9999565522")
                .email("dp@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .lastName("Verma")
                .emailId("Shivam@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> studentList = studentRepository.findByFirstName("Shivam");

        System.out.println("student list: " + studentList);

    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> studentList = studentRepository.findByFirstNameContaining("Sh");

        System.out.println("student list: " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {

        List<Student> studentList = studentRepository.findByGuardianName("Den Parker");
        System.out.println("student list: " + studentList);
    }

    @Test
    public void printGetStudentByEmailAddress() {

        Student student = studentRepository.getStudentByEmailAddress("sumitra@gmail.com");
        System.out.println("student=" + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {

        String firstName = studentRepository.getStudentFirstNameByEmailAddress("sumitra@gmail.com");
        System.out.println("firstName=" + firstName);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNative() {

        Student student = studentRepository.getStudentByEmailAddressNative("sumitra@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNativeNamedParam() {

        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("sumitra@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {

       studentRepository.updateStudentNameByEmailId("Shivum","Shivam@gmail.com");
    }

}