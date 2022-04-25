package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Request.DepartmentRequest;
import com.example.demo.Request.EmployeeRequest;
import com.example.demo.Service.EmployeeNewService;
import com.example.demo.enums.ApiResponseCode;
import com.example.demo.response.Generics.ResponseDTO;
import com.example.demo.response.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeNewController {

    @Autowired
    private EmployeeNewService service;

    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostMapping(value = "/create")
    public String saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return service.saveEmployee(employeeRequest);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployee() {
        return service.getEmployee();
    }

    @GetMapping("/single/{id}")
    public ResponseDTO<?> getEmployeeById(@PathVariable("id") int id) throws Exception {
        Employee employee = service.getEmployeeById(id);
        return responseUtil.ok(service.getEmployeeById(id), ApiResponseCode.SUCCESS);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return id + "Employee deleted Successfully";
    }

    @PutMapping("/update")
    public String updateEmployee(Employee employee) {
        service.updateEmployee(employee);
        return "employee updated successfully";
    }

}
