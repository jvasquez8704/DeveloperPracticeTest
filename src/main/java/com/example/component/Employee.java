package com.example.component;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"firstname", "lastname", "identification", "enrollday", "telephones", "profile", "projects", "celula"})
public class Employee {	
	
	private String firstname;    
    private String lastname;    
    private String identification;    
    private String enrollday;   
    private String telephones;    
    private String profile;    
    private String projects;    
    private String celula;
    
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
	public String getEnrollday() {
		return enrollday;
	}
	public void setEnrollday(String enrollday) {
		this.enrollday = enrollday;
	}
	public String getTelephones() {
		return telephones;
	}
	public void setTelephones(String telephones) {
		this.telephones = telephones;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getCelula() {
		return celula;
	}
	public void setCelula(String celula) {
		this.celula = celula;
	}    
    

}
