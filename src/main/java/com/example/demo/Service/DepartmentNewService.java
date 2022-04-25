package com.example.demo.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Request.DepartmentRequest;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentNewService {

    @Autowired
    public DepartmentRepository repository;

//    public Department saveDepartment(Department department){
//      return repository.save(department);
//
//    }

    public String saveDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setDeptName(departmentRequest.getDeptName());
        department.setD_id(departmentRequest.getDeptId());
        department.setDeptCity(departmentRequest.getDeptCity());
        repository.save(department);
        return "department inserted";
    }

    public DepartmentRepository getRepository() {
        return repository;
    }

    public List<Department> getDepartment() {
        return repository.findAll();
    }

    public Department getDepartmentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteDepartment(int id) {
        repository.deleteById(id);
        return "department removed:" + id;
    }

    public String updateDepartment(Department department) {
        Department department1 = repository.findById(department.getD_id()).orElse(null);
        department1.setDeptName(department.getDeptName());
        department1.setDeptCity(department.getDeptCity());
        repository.save(department1);
        return "Update successful";
    }

}
