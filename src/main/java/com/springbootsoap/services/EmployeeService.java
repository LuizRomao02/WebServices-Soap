package com.springbootsoap.services;

import com.springbootsoap.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public Employee getEmployeeById(long employeeId);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(long employeeId);
}
