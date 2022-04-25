package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.sun.istack.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.aspectj.bridge.Message;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "department")
public class Department {
    @Id
    private int d_id;
    @Column(name="department_name")
    private String deptName;
    @Column(name="city")
    private String deptCity;
    //@JsonManagedReference
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Employee> employee;

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getDeptName() { return deptName; }
    public void setDeptName(String department_name) {
        this.deptName = department_name;
    }

    public String getDeptCity() {
        return deptCity;
    }

    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

}
