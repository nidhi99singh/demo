//package com.example.demo.Controller;
//
//import com.example.demo.Entity.Department;
//import com.example.demo.Request.DepartmentRequest;
//import com.example.demo.Service.DepartmentNewService;
//import com.example.demo.Service.DepartmentServices;
//import com.example.demo.enums.ApiResponseCode;
//import com.example.demo.exception.ValidationException;
//import com.example.demo.repository.DepartmentRepository;
//import com.example.demo.response.Generics.ResponseDTO;
//import com.example.demo.response.utils.ResponseUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api(value = "department controller")
//@RestController
//@RequestMapping("/api/department")
//public class DepartmentController {
//
//    @Autowired
//    private DepartmentServices departmentService;
//
//    @Autowired
//    private DepartmentNewService service;
//    @Autowired
//    private ResponseUtil responseUtil;
//
//    @Autowired
//    private DepartmentRepository repository;
//    //get department by id
//    @ApiOperation(value = "get by id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
//    })
//    @GetMapping("/single/{id}")
//    public ResponseDTO<?> getDepartmentById(@PathVariable("id") int id) throws Exception {
//        Department department=departmentService.getDepartmentById(id);
//     //   return department;
//        return responseUtil.ok(departmentService.getDepartmentById(id), ApiResponseCode.SUCCESS);
//         }
//
//    // get all department records
//    @GetMapping("/getAll")
//    @ResponseBody
//    public List getAllDepartment() {
//        List<Department> allList = departmentService.getAllDepartment();
//        return allList;
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
//        return departmentService.saveDepartment(departmentRequest);
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    public String updateDepartment(@RequestBody DepartmentRequest departmentRequest) throws ValidationException {
//        return departmentService.updateDepartment(departmentRequest);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable int id) {
//        return departmentService.deleteDepartment(id);
//    }
//
//
//
//}
//
