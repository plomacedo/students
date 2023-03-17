package com.fiap.spring.students;

import com.fiap.spring.students.entities.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

        @Test
        public void StuTest() {
            Student student = new Student("name", "123455667");
            assertEquals("name", student.getName() );
        }
    }

