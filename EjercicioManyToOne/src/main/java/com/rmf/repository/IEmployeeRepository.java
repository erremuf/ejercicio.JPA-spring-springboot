package com.rmf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmf.entity.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
	
	 Employee findById(long id);
	 List<Employee> findByDepartmentId(Long departmentId);


}
