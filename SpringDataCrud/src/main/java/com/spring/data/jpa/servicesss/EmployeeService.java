package com.spring.data.jpa.servicesss;

import java.util.List;

import com.spring.data.jpa.bean.Employee;

public interface EmployeeService {

	void addEmployee(Employee emp);

	List<Employee> getEmployee_by_Name(String string);

	List<Employee> findByEidAndName(int i, String string);

	void updateEmployee(String name, int eid);

	Employee retrieve_Employee_details(int empId);

	int updateEmployee(int eId, String empName);

	int delete_from_employee_managment(int eid);

}
