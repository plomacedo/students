package com.fiap.spring.students.batch;


import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.entities.Student;
import org.springframework.stereotype.Component;

import static com.fiap.spring.students.mappers.StudentMapper.maptoStudentDTO;

@Component
public class ItemProcessor implements org.springframework.batch.item.ItemProcessor<Student, StudentDTO> {

    @Override
    public StudentDTO process(Student student) throws Exception {
        student.setName(student.getName().split("  ")[0]);
        return maptoStudentDTO( student );
    }
}
