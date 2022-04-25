//package com.example.demo.Service;
//import com.example.demo.Entity.Department;
//import com.example.demo.Request.DepartmentRequest;
//import com.example.demo.exception.ValidationException;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class DepartmentServices {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    //get department by Id
//    public Department getDepartmentById(int id) throws ValidationException {
//           Session session = this.sessionFactory.getCurrentSession();
//            Department d = (Department) session.get(Department.class, id);
//
//             if (Objects.isNull(d)) {
          //throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Department details does not exist");
//            }
//        return d;
//    }
//
//    // list all departments
//    public List<Department> getAllDepartment() {
//        Session session = this.sessionFactory.getCurrentSession();
//        List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
//
//        return departments;
//    }
//    // add new department
//    public String saveDepartment(DepartmentRequest departmentRequest) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            Department department = new Department();
//            department.setD_id(departmentRequest.getDeptId());
//            department.setDeptName(departmentRequest.getDeptName());
//            department.setDeptCity(departmentRequest.getDeptCity());
//            transaction = session.beginTransaction();
//            session.save(department);
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
//        return "Insertion Successful";
//    }
//    //update department
//    public String updateDepartment(DepartmentRequest departmentRequest) throws ValidationException {
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//          try{
//            Department department = session.get(Department.class, departmentRequest.getDeptId());
//            if(Objects.isNull(department)) {
//                throw new ValidationException(HttpStatus.BAD_REQUEST.value(), "Department details does not exist");
//            }
//                department.setDeptName(departmentRequest.getDeptName());
//                department.setDeptCity(departmentRequest.getDeptCity());
//                transaction = session.beginTransaction();
//
//                session.saveOrUpdate(department);
//                transaction.commit();
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
//    public String deleteDepartment(int id) {
//        Session session = this.sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            Department department = session.get(Department.class, id);
//            if(Objects.isNull(department)){
//                throw new ValidationException(HttpStatus.BAD_REQUEST.value(),"Department doest not exist");
//            }
//                transaction = session.beginTransaction();
//                session.delete(department);
//                transaction.commit();
//
//        } catch (HibernateException e) {
//            if (transaction != null)
//                transaction.rollback();
//            e.printStackTrace();
//
//        } catch (ValidationException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (session != null) session.close();
//            } catch (Exception ex) {
//            }
//        }
//        return "Delete Successful";
//
//    }
//}
