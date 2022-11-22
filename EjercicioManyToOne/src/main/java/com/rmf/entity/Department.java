package com.rmf.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "DEPARTMENT")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dateCreated = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastUpdated = new Date();
	
	@Column(name = "nombre")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> employees;

	
	
	// GETTER / SETTER
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	
	// TO STRING
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", name="
				+ name + "]";
	}
	
	





}
