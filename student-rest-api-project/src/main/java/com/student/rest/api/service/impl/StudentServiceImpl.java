package com.student.rest.api.service.impl;

import com.student.rest.api.dto.StudentDto;
import com.student.rest.api.entity.Student;
import com.student.rest.api.repository.StudentRepository;
import com.student.rest.api.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        return modelMapper.map(studentRepository.save(modelMapper.map(studentDto, Student.class)),StudentDto.class);
    }

    @Override
    public StudentDto findById(int id) {
        return modelMapper.map(studentRepository.findById(id).get(),StudentDto.class);
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = this.studentRepository.findAll();
        List<StudentDto> studentDtoList = students.stream()
                .map(student -> modelMapper.map(student,StudentDto.class)).collect(Collectors.toList());
        return studentDtoList;
    }

    @Override
    public StudentDto updateStudent(int id, StudentDto studentDto) {
       Student student = modelMapper.map(studentDto, Student.class);
       student.setId(id);
       Student updateStudent = studentRepository.save(student);
        return this.modelMapper.map(updateStudent,StudentDto.class);
    }

    @Override
    public Boolean deleteById(int id) {
        this.studentRepository.delete(studentRepository.findById(id).get());
        return true;
    }
}
