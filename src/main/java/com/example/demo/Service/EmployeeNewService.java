package com.example.demo.Service;

import com.example.demo.Entity.Department;
import com.example.demo.Entity.Employee;
import com.example.demo.Request.EmployeeRequest;
import com.example.demo.repository.EmployeeRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class EmployeeNewService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setE_id(employeeRequest.getE_id());
        employee.setFirstname(employeeRequest.getFirstname());
        employee.setLastname(employeeRequest.getLastname());
        employee.setAge(employeeRequest.getAge());
        employee.setCity(employeeRequest.getCity());
        employee.setSalary(employeeRequest.getSalary());
        employeeRepository.save(employee);
        return "employee added successfully";
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "department removed:" + id;
    }

    public String updateEmployee(Employee employee) {
        Employee employee1 = employeeRepository.findById(employee.getE_id()).orElse(null);
        employee1.setFirstname(employee.getFirstname());
        employee1.setCity(employee.getCity());
        employeeRepository.save(employee1);
        return "Employee Update successful";
    }


}
