package com.korsuk.hibernate;

import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            StudentDAO studentDao = new StudentDaoImpl(sessionFactoryUtils);
            for (int i = 1; i < 1001; i++) {
                Student student = new Student();
                student.setName("Robot" + i);
                student.setMark(new Random().nextInt(10));
                studentDao.save(student);
            }

            studentDao.deleteById(500L);

            Student student = studentDao.findById(109L);
            System.out.println(student.toString());

            studentDao.update(105L, "human");

            System.out.println(studentDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
