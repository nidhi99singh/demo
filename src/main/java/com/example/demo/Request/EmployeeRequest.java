package com.example.demo.Request;

import javax.validation.constraints.NotNull;

public class EmployeeRequest {
    private int e_id;
    @NotNull(message = "FirstName not provided")
    private String firstname;
    @NotNull(message = "Lastname not provided ")
    private String lastname;
    @NotNull(message = "City not provided")
    private String city;
    @NotNull(message = "salary can not be null")
    private int salary;
    private int age;
    private String deptName;


    public String getdeptName() {
        return deptName;
    }

    public void setD_id(String deptName) { this.deptName=deptName;}

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
