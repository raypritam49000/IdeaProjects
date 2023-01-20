package com.student.rest.api.service;

import com.student.rest.api.dto.StudentDto;

import java.util.List;

public interface IStudentService {
public StudentDto createStudent(StudentDto studentDto);
public StudentDto findById(int id);
public List<StudentDto> findAll();
public StudentDto updateStudent(int id,StudentDto studentDto);
public Boolean deleteById(int id);
}
