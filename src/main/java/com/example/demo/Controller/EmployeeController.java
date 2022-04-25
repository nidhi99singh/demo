//package com.example.demo.Controller;
//
//import com.example.demo.Entity.Employee;
//import com.example.demo.Request.EmployeeRequest;
//import com.example.demo.Service.EmployeeService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/employee")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    //get employee by Id
//
//    @GetMapping("/single/{id}")
//    public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) throws JsonProcessingException {
//        Employee employee = employeeService.getEmployeeById(id);
//        if (employee == null) {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode json = mapper.readTree("{\"error\": \"No employee found \"}");
//            return ResponseEntity.ok(json);
//        } else {
//            return ResponseEntity.ok(employee);
//        }
//    }
//
//    //get all employees
//    @GetMapping("/getAll")
//    @ResponseBody
//    public List getAllEmployees() {
//        List<Employee> allList = employeeService.getAllEmployees();
//        return allList;
//    }
//
//    //create employee
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String saveEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
//        return employeeService.saveEmployee(employeeRequest);
//    }
//
//    //Update employee table
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public String updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
//        return employeeService.updateEmployee(employeeRequest);
//    }
//
//    //delete employee
//    @DeleteMapping("/delete/{id}")
//    public String deleteEmployee(@PathVariable int id) {
//        return employeeService.deleteEmployee(id);
//    }
//
//    //max salary employee
//    @RequestMapping(value = "/maxsalary", method = RequestMethod.GET)
//    public List<Employee> getMaxSalaryEmployee(){
//        return employeeService.getMaxSalaryEmployee();
//    }
//
//    //min salary employee
//    @RequestMapping(value="/minsalary",method=RequestMethod.GET)
//    public List<Employee> getMinSalaryEmployee(){
//        return employeeService.getMinSalaryEmployee();
//    }
//
//    //first 3 employee with highest salary
//    @RequestMapping(value = "/salary", method = RequestMethod.GET)
//    public List<Employee> getSalaryEmployee(){
//        return employeeService.getSalaryEmployee();
//    }
//
//    //total salary paid by company
//    @RequestMapping(value = "/totalsalary/{city}", method = RequestMethod.GET)
//    public List<Employee> getTotalSalary(){
//        return employeeService.getTotalSalary();
//    }
//
//    //Employee who lives in city X
//    @RequestMapping(value = "/city", method = RequestMethod.GET)
//    public List <Employee> getEmployeeCity(EmployeeRequest employeeRequest){
//        return employeeService.getEmployeeCity(employeeRequest);
//    }
//
//    //Age greater than average age
//    @RequestMapping(value = "/Avgage", method = RequestMethod.GET)
//    public List<Employee> getEmployeebyAge(){
//        return employeeService.getEmployeebyAge();
//    }
//    @RequestMapping(value="/descsalary",method=RequestMethod.GET)
//    public List<Employee> getDescEmployee(){
//        return employeeService.getDescEmployee();
//    }
//
//    // average salary department wise
//    @RequestMapping(value="/avgsalarydepartment", method = RequestMethod.GET)
//    public List<Employee>getAvgDepartmentSalary(){
//        return employeeService.getAvgDepartmentSalary();
//    }
//    //display employees with department name
//    @RequestMapping(value="/salarymorethananydepartment", method = RequestMethod.GET)
//    public List<Employee> getEmployeeWithDepartment(){
//        return employeeService.getEmployeeWithDepartment();
//    }
//    @RequestMapping(value="/employeewithdepartment", method = RequestMethod.GET)
//    public List<Employee> getEmployeeWithDepartment1(){
//        return employeeService.getEmployeeWithDepartment1();
//    }
//}
//
//
//
