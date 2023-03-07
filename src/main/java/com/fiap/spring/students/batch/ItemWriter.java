package com.fiap.spring.students.batch;

import java.util.List;

import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemWriter implements org.springframework.batch.item.ItemWriter<StudentDTO> {

    @Autowired
    StudentService service;

    @Override
    public void write(List<? extends StudentDTO> list) throws Exception {

        for(int i=0;i<list.size();i++){
            if(!list.get(i).getName().equals("")){
                service.createStudent( list.get( i ) );
            }

        }
    }
}