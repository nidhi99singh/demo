package com.example.demo.Controller;

import com.example.demo.Entity.Department;
import com.example.demo.Request.DepartmentRequest;
import com.example.demo.Service.DepartmentNewService;
import com.example.demo.enums.ApiResponseCode;
import com.example.demo.response.Generics.ResponseDTO;
import com.example.demo.response.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/newdepartment")
public class DepartmentNewController {

    @Autowired
    private DepartmentNewService service;

    @Autowired
    private ResponseUtil responseUtil;

    //    @PostMapping("/savedepartment")
//    public Department saveDepartment(@RequestBody Department department){
//        return service.saveDepartment(department);
//    }
    @PostMapping("/create")
    public String saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return service.saveDepartment(departmentRequest);
    }

    @GetMapping("/getalldepartments")
    public List<Department> findAlldepartments() {
        return service.getDepartment();
    }

    @GetMapping("/single/{id}")
    public ResponseDTO<?> getDepartmentById(@PathVariable("id") int id) throws Exception {
        Department department = service.getDepartmentById(id);
        return responseUtil.ok(service.getDepartmentById(id), ApiResponseCode.SUCCESS);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteDepartment(@PathVariable int id) {
        service.deleteDepartment(id);
        return id + "Department deleted Successfully";
    }

    @PutMapping("/update")
    public String updateDepartment(Department department) {
        service.updateDepartment(department);
        return "department updated successfully";
    }

}
