package com.spring.data.jpa.servicesss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.jpa.bean.Employee;
import com.spring.data.jpa.repos.EmployeeRepositorie;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositorie employeeRepositorie;

	public void addEmployee(Employee emp) {

		employeeRepositorie.saveAndFlush(emp);

	}

	public List<Employee> getEmployee_by_Name(String name) {

		List<Employee> emp = employeeRepositorie.findByName(name);

		return emp;
	}

	public List<Employee> findByEidAndName(int i, String string) {
		List<Employee> employees = employeeRepositorie.findByEidAndName(i, string);

		return employees;
	}

	public void updateEmployee(String name, int eid) {

		employeeRepositorie.update_employee(name, eid);

	}

	public Employee retrieve_Employee_details(int empId) {

		Employee employee_details = employeeRepositorie.findByEid(empId);
		return employee_details;

	}

	public int updateEmployee(int eId, String empName) {

		int r = employeeRepositorie.updateEmployeeName(empName, eId);
		return r;

	}

	public int delete_from_employee_managment(int eid) {

		int result=employeeRepositorie.deleteEmployeeDetails(eid);

		return result;
	}

}
