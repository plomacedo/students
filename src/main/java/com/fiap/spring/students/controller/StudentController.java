package com.fiap.spring.students.controller;


import com.fiap.spring.students.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.spring.students.services.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/alunos")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student){
        StudentDTO savedStudent = service.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public StudentDTO findById(@PathVariable UUID id){
        return service.findStudentById(id);
    }

}
