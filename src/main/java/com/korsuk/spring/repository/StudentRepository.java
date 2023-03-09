package com.korsuk.spring.repository;

import com.korsuk.spring.entity.Student;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s order by s.id")
    List<Student> findAll();

    Student findStudentById(Long id);

    Student findStudentByName(String name);

    @Query("select s from Student s where s.name = ?1")
    Optional<Student> findByName(String name);

    void deleteStudentById(Long id);

    @NonNull
    Student saveAndFlush (Student student);
}