package com.korsuk;

import com.korsuk.oop.builder.Person;

public class Main {
    public static void main(String[] args) {

        Person person = new Person.PersonBuilder()
                .firstName("Bill")
                .lastName("Johnson")
                .age(45)
                .build();
        System.out.println(person);
    }
}