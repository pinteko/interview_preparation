package com.korsuk.oop.builder;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(PersonBuilder personBuilder) {
        if (personBuilder == null) {
            throw new IllegalArgumentException("Please provide person builder.");
        }
        if (personBuilder.firstName == null || personBuilder.lastName == null
                || personBuilder.firstName.trim().isEmpty() || personBuilder.lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide person name and last name.");
        }
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.middleName = personBuilder.middleName;
        this.country = personBuilder.country;
        this.address = personBuilder.address;
        this.phone = personBuilder.phone;
        this.age = personBuilder.age;
        this.gender = personBuilder.gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person [first_name: ").append(firstName).append(", last_name: ").append(lastName)
                .append(", middle_name: ").append(middleName).append(", country: ").append(country)
                .append(", address: ").append(address).append(", phone: ").append(phone).append(", age: ")
                .append(age).append(", gender: ").append(gender).append("]");
        return builder.toString();
    }

    public static class PersonBuilder {

        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        public PersonBuilder() {
            super();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder country(String country) {
            this.country = country;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            Person person = null;
            if (validatePerson()) {
                person = new Person(this);
            } else {
                System.out.println("Sorry! Person objects can't be build without required details");
            }
            return person;
        }

        private boolean validatePerson() {
            return (firstName != null && !firstName.trim().isEmpty()
                    && lastName != null && !lastName.trim().isEmpty());
        }
    }
}
