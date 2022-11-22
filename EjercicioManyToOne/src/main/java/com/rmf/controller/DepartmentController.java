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

import com.rmf.entity.Department;
import com.rmf.services.DepartmentService;

@Controller
@SessionAttributes("department")
@RequestMapping(value="department")
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;
	
	
	// INICIO

	@GetMapping("/list")
	public String departmentService(Model model) {
		model.addAttribute("titulo", "Lista de departamentos");
		model.addAttribute("lista", depService.list());
		
		return "department/list";
	}
	
	
	// AÑADIR NUEVO
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("titulo", "Añadir un departamento");
		model.addAttribute("department", new Department());
		
		return "department/create";
	}
	
	@PostMapping("/create")
	public String save(Department department) {
		department = depService.save(department); //mirar esto o quitar el igual
		
		return "redirect:/department/list";
	}
	
	
	// VER DETALLES DEL DEPARTAMENTO
	
	@GetMapping("/show/{id}")
	public String details(@PathVariable(name="id") long id, Model model) {
		model.addAttribute("titulo","Detalles del departamento");
		model.addAttribute("department", depService.get(id)) ;
		
		return "department/show";
	}
	
	
	// EDITAR DEPARTAMENTO
	
	@GetMapping("/edit/{id}")
	public String upDate(@PathVariable(name="id") long id, Model model) {
		model.addAttribute("titulo", "Editar departamento");
		model.addAttribute("department", depService.get(id));
		
		return "department/edit";
	}
	
	@PostMapping("/update")
	public String saveUpDate(Department department, SessionStatus status) {
		department = depService.update(department); //mirar esto o quitar el igual
		status.setComplete();
		
		return "redirect:/department/list";
	}
	
	
	// ELIMINAR DEPARTAMENTO
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") long id, Model model) {
		depService.delete(depService.get(id));
		
		return "redirect:/department/list";
	}
	

}
