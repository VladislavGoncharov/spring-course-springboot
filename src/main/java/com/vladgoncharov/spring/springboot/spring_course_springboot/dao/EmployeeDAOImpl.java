package com.vladgoncharov.spring.springboot.spring_course_springboot.dao;



import com.vladgoncharov.spring.springboot.spring_course_springboot.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> allEmployee = entityManager.createQuery("from Employee", Employee.class).getResultList();
        return allEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
       return entityManager.find(Employee.class,id);

    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.remove(getEmployee(id));

    }

}
