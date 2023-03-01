package com.fiap.spring.students.mappers;

import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.entities.Student;

public class StudentMapper {

    public static StudentDTO maptoStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEnrollment()
        );
        return studentDTO;
    }

    public static Student mapToStudent (StudentDTO studentDTO){
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getEnrollment()
        );
        return student;
    }
}
