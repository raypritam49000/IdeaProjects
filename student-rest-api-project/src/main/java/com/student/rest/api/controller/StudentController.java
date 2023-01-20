package com.student.rest.api.controller;

import com.student.rest.api.dto.StudentDto;
import com.student.rest.api.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
      return studentService.createStudent(studentDto);
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable("id") int id){
        return studentService.findById(id);
    }

    @GetMapping("")
    public List<StudentDto> getAllStudents(){
        return studentService.findAll();
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable("id") int id,@RequestBody StudentDto studentDto){
        return studentService.updateStudent(id, studentDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStudent(@PathVariable("id") int id){
        return studentService.deleteById(id);
    }
}
