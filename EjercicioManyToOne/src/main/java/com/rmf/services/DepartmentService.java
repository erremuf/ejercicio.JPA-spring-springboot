package com.rmf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmf.entity.Department;
import com.rmf.repository.IDepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	public List<Department> list() {
		
		return departmentRepository.findAll();
		}
	
	public Object delete(Department department){
		departmentRepository.delete(department);
		
		return department;
		}
	
	public Department update(Department department) {
		
		return departmentRepository.save(department);
		}
	
	public Department save(Department department) {
		
		return departmentRepository.save(department);
		}
	
	public Department get(long id) {
		
		return departmentRepository.findById(id).get();
		}
	


}

