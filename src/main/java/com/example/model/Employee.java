package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    int id;

	    @Column
	    private String firstname;

	    @Column
	    private String lastname;

	    @Column
	    private String identification;
	    
	    @Column
	    private Date enrollday; 
	    
	    
	    /*foreign keys*/
	    
	    @Column
	    private int idProfile;
	    
	    @Column
	    private int idCelula;

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

		public String getIdentification() {
			return identification;
		}

		public void setIdentification(String identification) {
			this.identification = identification;
		}

		public Date getEnrollday() {
			return enrollday;
		}

		public void setEnrollday(Date enrollday) {
			this.enrollday = enrollday;
		}

		public int getIdProfile() {
			return idProfile;
		}

		public void setIdProfile(int idProfile) {
			this.idProfile = idProfile;
		}

		public int getIdCelula() {
			return idCelula;
		}

		public void setIdCelula(int idCelula) {
			this.idCelula = idCelula;
		}    
	    
	    
	    /*Getters and Setters*/
	    
	    
}
