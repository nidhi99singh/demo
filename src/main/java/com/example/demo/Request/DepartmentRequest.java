package com.example.demo.Request;

public class DepartmentRequest {

    private int deptId;
    private String deptName;
    private String deptCity;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int d_id) {
        this.deptId = d_id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String department_name) { this.deptName = department_name; }

    public String getDeptCity() {
        return deptCity;
    }

    public void setDeptCity(String city) {
        this.deptCity = city;
    }
}

