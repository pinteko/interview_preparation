package com.korsuk.spring.controller;

import com.korsuk.spring.dto.StudentDto;
import com.korsuk.spring.dto.StudentToSave;
import com.korsuk.spring.entity.Student;
import com.korsuk.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("students", studentService.getAllStudent());
//        return "showStudents";
//    }

    @GetMapping()
    public List<StudentDto> findAll() {
        return studentService.getAllStudent();
    }

    @DeleteMapping
    public void deleteStudent(@RequestParam Long id) {
            studentService.deleteStudent(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody @NotNull StudentToSave newStudent){
        Student student = new Student();
        student.setName(newStudent.getName());
        student.setAge(newStudent.getAge());
        return studentService.saveStudent(student);
    }

    @PatchMapping
    public Student editStudent(@RequestParam Long id, @RequestParam String name, @RequestParam Integer age) {
        return studentService.editStudent(id, name, age);
    }
}