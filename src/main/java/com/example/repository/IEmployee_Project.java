package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Employee_Project;

public interface IEmployee_Project extends JpaRepository<Employee_Project, Integer> {
	List<Employee_Project> findByIdEmployee(int idEmployee);
}
