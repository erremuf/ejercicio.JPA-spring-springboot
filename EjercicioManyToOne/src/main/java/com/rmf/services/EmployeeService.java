package com.rmf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmf.entity.Department;
import com.rmf.entity.Employee;
import com.rmf.repository.IDepartmentRepository;
import com.rmf.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	public Object list() {
		return employeeRepository.findAll();
	}
	
	public Employee save(Employee employee) {
		
		Department department = departmentRepository.getReferenceById(employee.getDepartment().getId());
		employee.setDepartment(department);
		employee = employeeRepository.save(employee);
		
		return employee;
	}
	
	public Employee get(long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> list(long departmentId) {
		return employeeRepository.findAll();
	}
	


}
