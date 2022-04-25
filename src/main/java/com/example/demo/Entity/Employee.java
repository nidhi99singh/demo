package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "employee")
public class Employee {
    @Id
    private int e_id;

    //@Column(name = "first_name")
    private  String firstName;

    //@Column(name = "last_name")
    private String lastName;

    private int age;
    private int salary;
    private String city;

    //@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "deptId",nullable = false )
    private Department department;

    public void setD_id(int dId) {
       this.department.setD_id(dId);

    }

    public void setDepartment(Department department){ this.department=department;}
    public Department getDepartment() {
        return department;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
