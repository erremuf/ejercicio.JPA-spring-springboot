package com.rmf.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dateCreated = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastUpdated = new Date();
	
	@Column(name = "direccion")
	private String address;
	
	
	/*
	 * @OneToOne(fetch = FetchType.LAZY) private Employee employee;
	 */
	 

	


	// CONSTRUCTORS
	
	public Address() {}
	
	public Address(long id, Date dateCreated, Date lastUpdated, String address, Employee employee) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.address = address;
	//	this.employee = employee;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * public Employee getEmployee() { return employee; }
	 * 
	 * public void setEmployee(Employee employee) { this.employee = employee; }
	 */

	
	
	// TO STRING
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", dateCreated=" + dateCreated + ", lastUpdated=" + lastUpdated + ", address="
				+ address + "]";
	}



}



