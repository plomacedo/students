package com.fiap.spring.students.controller;


import com.fiap.spring.students.dto.StudentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fiap.spring.students.services.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/alunos")
@Api(value="API REST Students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    @ApiOperation(value="this method creates a new student")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student){
        StudentDTO savedStudent = service.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value="this method returns the list of all students")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> students = service.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="this method returns a single student by id")
    public StudentDTO findById(@PathVariable UUID id){
        return service.findStudentById(id);
    }

}
