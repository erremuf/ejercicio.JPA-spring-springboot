package com.rmf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.rmf.entity.Employee;
import com.rmf.services.DepartmentService;
import com.rmf.services.EmployeeService;

@Controller
@SessionAttributes("employee")
@RequestMapping(value="employee")
public class EmployeeController {
	
	

	@Autowired
	EmployeeService empService;
	
	@Autowired
	DepartmentService depService;
	
	
	// INICIO
	
	  @GetMapping("/list")
	  public String employeeService(Model model) {
		  model.addAttribute("titulo", "Lista de empleados");
		  model.addAttribute("lista", empService.list());
	  
		  return "employee/list";
	  }
	  
	// AÑADIR NUEVO EMPLEADO
	  
	  @GetMapping("/add")
	  public String add(Model model) {
		  
		 model.addAttribute("titulo", "Añadir nuevo empleado");
		 model.addAttribute("employee", new Employee());
		 model.addAttribute("listDepartment", depService.list());
		  
		  return "employee/add";
	  }
	  
	  @PostMapping("/add")
	  public String save(Employee employee, Model model) {
		  System.out.println(employee.getAddress());
		  employee = empService.save(employee);
		  model.addAttribute("employee", employee);
		  
		return "redirect:/employee/show/" + employee.getId();
	  }
	  
	  
	  
	// VER DETALLES DEL EMPLEADO
	  
	  @GetMapping("/show/{id}")
	  public String details(@PathVariable(name="id") long id, Model model) {
		  model.addAttribute("titulo", "Detalles del empleado");
		  model.addAttribute("employee", empService.get(id));
	  
		  return "employee/show";
	  }
	  
	 
	// EDITAR EMPLEADO
	  
	  @GetMapping("/edit/{id}")
		public String upDate(@PathVariable(name="id") long id, Model model) {
			model.addAttribute("titulo", "Editar EMPLEADO");
			model.addAttribute("listDepartment", depService.list());
			model.addAttribute("department", empService.get(id));
			
			return "employee/edit";
		}
	  
	  @PostMapping("/update")
		public String saveUpDate(Employee employee, SessionStatus status) {
		  empService.update(employee); //mirar esto o quitar el igual
			status.setComplete();
			
			return "redirect:/employee/list";
		}
	  
	  
	// ELIMINAR EMPLEADO
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable(name="id") long id, Model model) {
			empService.delete(id);
			
			return "redirect:/employee/list";
		}
	

}
