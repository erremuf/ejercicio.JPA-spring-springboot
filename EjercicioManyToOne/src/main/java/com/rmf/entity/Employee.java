package com.rmf.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dateCreated = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastUpdated = new Date();
	
	@Column(name = "email")
	private String email;

	@Column(name = "nombre")
	private String name;

	@Column(name = "password")
	private String password;
	
	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;

	
	
	// CONSTRUCTORS
	
	public Employee() {}
	
	public Employee(Date dateCreated, Date lastUpdated, String email, String name, String password,
			Address address, Department department) {
		super();
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.department = department;
	}

	
	// GETTERS / SETTERS

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	



}
