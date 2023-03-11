package com.korsuk.spring.service;

import com.korsuk.spring.dto.StudentDto;
import com.korsuk.spring.entity.Student;
import com.korsuk.spring.repository.StudentRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

//    public Student getStudent(int id){
//        return studentRepository.findById(id);
//    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findStudentById(id);
        StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getAge());
        return studentDto;
    }

    public List<StudentDto> getAllStudent(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentsDto = students.stream().map(s -> new StudentDto(s.getId(),
                s.getName(), s.getAge())).collect(Collectors.toList());
        return studentsDto;
    }

    public StudentDto getStudentByName(String name) {
        Student student = studentRepository.findStudentByName(name);
        StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getAge());
        return studentDto;
    }


    @Transactional
    public Student saveStudent (@NonNull Student student) {
        Student savedStudent = studentRepository.saveAndFlush(student);
        return savedStudent;
    }

    @Transactional
    public Student editStudent (Long id, String name, Integer age) {
        Student student = studentRepository.findStudentById(id);
        student.setName(name);
        student.setAge(age);
        return studentRepository.saveAndFlush(student);
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteStudentById(id);
    }
}
