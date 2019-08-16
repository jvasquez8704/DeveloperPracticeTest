package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee_Project {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    private int workedhours;
    
    /*foreign keys*/    
    @Column
    private int idEmployee;
    
    @Column
    private int idProject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWorkedhours() {
		return workedhours;
	}

	public void setWorkedhours(int workedhours) {
		this.workedhours = workedhours;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
    
}
