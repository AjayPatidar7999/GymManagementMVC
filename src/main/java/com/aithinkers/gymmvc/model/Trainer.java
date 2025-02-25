package com.aithinkers.gymmvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trainer")
public class Trainer {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="specialization")
	private String specialization;
	
	@Column(name="experience_years")
	private String experienceYears;

	
	@Column(name="phone_number")
	private String phoneNumber;

	// Constructors
	
	public Trainer() {
	}

	public Trainer(String firstName, String lastName, String email, String specialization, String experienceYears, String phoneNumber) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.email = email;
	    this.specialization = specialization;
	    this.experienceYears = experienceYears; // Allow null values
	    this.phoneNumber = phoneNumber;
	}

	// Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExperienceYears() { 
	    return experienceYears; 
	}


	public void setExperienceYears( String experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// toString() method

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + 
		       ", email=" + email + ", specialization=" + specialization + 
		       ", experienceYears=" + experienceYears + ", phoneNumber=" + phoneNumber + "]";
	}
}
