//package com.example.demo.Service;
//import com.example.demo.Entity.Department;
//import com.example.demo.Entity.Employee;
//import com.example.demo.Request.EmployeeRequest;
//import org.hibernate.*;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRange;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpStatusCodeException;
//
//import javax.xml.bind.ValidationException;
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    SessionFactory sessionFactory;
//
//    //get employee by id
//    public Employee getEmployeeById(int id) {
//        Employee e = null;
//        try {
//            Session session = this.sessionFactory.getCurrentSession();
//            e = (Employee) session.get(Employee.class, new Integer(id));
//        } catch (ObjectNotFoundException ex) {
//            return null;
//        }
//        return e;
//    }
//
//    // get all employees
//    public List<Employee> getAllEmployees() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
//        return employees;
//    }
//
//    public String saveEmployee(EmployeeRequest employeeRequest) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            Employee employee = new Employee();
//            Department department=new Department();
//            employee.setE_id(employeeRequest.getE_id());
//            employee.setFirstname(employeeRequest.getFirstname());
//            employee.setLastname(employeeRequest.getLastname());
//            employee.setAge(employeeRequest.getAge());
//            employee.setSalary(employeeRequest.getSalary());
//            employee.setCity(employeeRequest.getCity());
//
//            Query query=session.createQuery("from Department where deptName=:deptName");
//            query.setParameter("deptName",employeeRequest.getdeptName());
//            List <Department> departmentdetails=query.list();
//            employee.setDepartment(departmentdetails.get(0));
//            transaction = session.beginTransaction();
//            session.save(employee);
//            transaction.commit();
//
//        } catch (HibernateException e) {
//             if (transaction != null)
//                transaction.rollback();
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (session != null) session.close();
//            } catch (Exception ex) {
//            }
//        }
//        return "Insertion Successful";
//    }
//
//    //update Employee
//    public String updateEmployee(EmployeeRequest employeeRequest) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            Employee employee = session.get(Employee.class, employeeRequest.getE_id());
//            employee.setLastname(employeeRequest.getLastname());
//            employee.setCity(employeeRequest.getCity());
//            transaction = session.beginTransaction();
//            session.saveOrUpdate(employee);
//            transaction.commit();
//
//        } catch (HibernateException e) {
//            if (transaction != null)
//                transaction.rollback();
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (session != null) session.close();
//            } catch (Exception ex) {
//            }
//        }
//        return "Update Successful";
//    }
//
//    //delete employee
//    public String deleteEmployee(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            Employee employee = session.get(Employee.class, id);
//            transaction = session.beginTransaction();
//            session.delete(employee);
//            transaction.commit();
//
//        } catch (HibernateException e) {
//            if (transaction != null)
//                transaction.rollback();
//            e.printStackTrace();
//
//        } finally {
//            try {
//                if (session != null) session.close();
//            } catch (Exception ex) {
//            }
//        }
//        return "Delete Successful";
//
//    }
//
//    //maximum salary
//    public List<Employee> getMaxSalaryEmployee(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("from Employee order by salary desc");
//        query.setMaxResults(1);
//        List <Employee> employee=query.list();
//        return employee;
//    }
//    //min salalry employee
//    public List<Employee> getMinSalaryEmployee(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("from Employee order by salary asc");
//        query.setMaxResults(1);
//        List <Employee> employee=query.list();
//        return employee;
//    }
//
//    //first 5 employees
//    public List<Employee> getSalaryEmployee(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("from Employee order by salary desc");
//        query.setMaxResults(3);
//        List <Employee> employee=query.list();
//        return employee;
//    }
//
//    //total salary paid by company
//    public List<Employee> getTotalSalary(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("Select sum(salary) from Employee");
//        List <Employee> employee=query.list();
//        return employee;
//    }
//    //employee by city
//    public List<Employee>getEmployeeCity(EmployeeRequest employeeRequest){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("from Employee where city=:city");
//        query.setParameter("city",employeeRequest.getCity());
//        List <Employee> employee=query.list();
//        return employee;
//    }
//    //employee whose age is greater than average age
//    public  List <Employee> getEmployeebyAge(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("from Employee where age>(select avg(age) from Employee)");
//        List<Employee> employee=query.list();
//        return  employee;
//    }
//    //employee in descending order of salary
//    public List<Employee> getDescEmployee(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("from Employee order by salary desc");
//        List <Employee> employee=query.list();
//        return employee;
//    }
//    //average salary department wise
//    public List<Employee> getAvgDepartmentSalary(){
//      Session session=this.sessionFactory.getCurrentSession();
//      Query query=session.createQuery("Select avg(salary) from Employee group by deptId");
//        List<Employee> employee=query.list();
//        return  employee;
//    }
//    public List<Employee>getEmployeeWithDepartment(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query q=session.createQuery("Select avg(salary) from Employee group by deptId order by salary desc");
//        q.setMaxResults(1);
//        Query query=session.createQuery("from Employee where salary>q.list()");
//        List<Employee> employee=query.list();
//        return  employee;
//    }
//    //employee details with department name
//    public List<Employee>getEmployeeWithDepartment1(){
//        Session session=this.sessionFactory.getCurrentSession();
//        Query query=session.createQuery("Select e.firstName,e.lastName,e.salary,d.deptName from Employee e inner join e.department d");
//        List<Employee> employee=query.list();
//        return  employee;
//    }
//
//}
