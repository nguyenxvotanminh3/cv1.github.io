package com.nguyenminh.cv1.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	// define field
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "email")
	private String email;
	public EmployeeEntity() {}
	// define constructor
	public EmployeeEntity(String firstname, String lastname, String email) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	// define getter/ setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// define tostring
	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ "]";
	}
	
}
