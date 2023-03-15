package com.fiap.spring.students.services;

import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.entities.Student;
import com.fiap.spring.students.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiap.spring.students.repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService{

    @Autowired
    private StudentRepository repository;

    public StudentDTO findStudentById(Long id){
        Student entity = repository.findById(id).get();
        StudentDTO dto = new StudentDTO(entity);
        return dto;
    }

    public StudentDTO createStudent(StudentDTO studentDTO){
        Student entity = StudentMapper.mapToStudent(studentDTO);
        Student savedStudent = repository.save(entity);
        StudentDTO savedStudentDTO = StudentMapper.maptoStudentDTO(savedStudent);
        return savedStudentDTO;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> entities = repository.findAll();
        return entities.stream().map( StudentMapper::maptoStudentDTO)
                .collect( Collectors.toList());
    }


}
