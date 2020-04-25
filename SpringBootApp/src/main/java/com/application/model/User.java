package com.application.model;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "required field")
    String surname;
    @NotBlank(message = "required field")
    String name;
    @NotBlank(message = "required field")
    String MiddleName;
    @NotNull(message = "required field")
    @Min(value = 0,message = "You must be over 14 years old")
    int Age;
    @NotNull(message = "required field")
    @Min(value = 0,message = "The salary must be greater than 0")
    int salary;
    @NotBlank(message = "required field")
    @Email(message = "Print correct email")
    String email;
    @NotBlank(message = "required field")
    String placeOfWork;
    @NotBlank(message = "required field")
    @Pattern(regexp = "\\+7[0-9]{10}", message = "The number must start with +7")
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }
}
