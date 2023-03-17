package com.fiap.spring.students;

import com.fiap.spring.students.entities.Student;
import com.fiap.spring.students.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void insertUser() {
        Student student = new Student("name", "123456");
        studentRepository.save(student);
        Integer countStudent = studentRepository.findAll().size();
        assertEquals(1, countStudent);
    }

}