package com.spring.data.jpa.presentaion_layer;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.data.jpa.bean.Employee;
import com.spring.data.jpa.configuration.SpringJpaConfiguration;
import com.spring.data.jpa.servicesss.EmployeeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("config.xml");
		 */

		/*
		 * Employee emp=new Employee(7, "sajjad"); service.addEmployee(emp);
		 */
		/*
		 * List<Employee> employee_details = service.getEmployee_by_Name("sajjad"); for
		 * (Employee e : employee_details) { System.out.println(e); }
		 */
		/*
		 * List<Employee> emp=service.findByEidAndName(7,"sajjad"); for(Employee e:emp)
		 * { System.out.println(e);
		 * 
		 * }
		 */

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringJpaConfiguration.class);
		EmployeeService service = context.getBean(EmployeeService.class);
		Scanner s = new Scanner(System.in);
		String empName;
		int empId;
		System.out.println("Welcome to Employee managment Portal");
		System.out.println("Choose the Options that you would like to go with");
		System.out.println("1. Add Employee Details");
		System.out.println("2. retrive Employee Details");
		System.out.println("3. update Employee Details");
		System.out.println("4. Delete Employee Details");

		int option = s.nextInt();
		switch (option) {

		case 1:
			System.out.println("Hi,welcome to Employee Portal");
			System.out.println("Please Enter your Name to Register");
			empName = s.next();
			Employee emp = new Employee(empName);
			service.addEmployee(emp);
			break;

		case 2:

			System.out.println("Plese Enter the Employee_Id to retrive EmployeeDetails");
			empId = s.nextInt();
			Employee employee_details = service.retrieve_Employee_details(empId);

			System.out.println(employee_details);
			break;

		case 3:
			System.out.println("Enter Employee Id that you Want Update");
			int eId = s.nextInt();
			System.out.println("Enter the Name That You Want to Update");
			empName = s.next();
			int i = service.updateEmployee(eId, empName);
			if (i > 0) {
				System.out.println(i + "Row Updated Successfully");
			} else {
				System.out.println("Fail to update");
			}
		case 4:
			System.out.println("Enter the Id that you want remove From Database");
			int eid = s.nextInt();
			int deleted = service.delete_from_employee_managment(eid);
			if (deleted > 0) {
				System.out.println("Record Deleted Successfully");
			} else {
				System.out.println("Problem in Deletion");
			}
		}

	}
}