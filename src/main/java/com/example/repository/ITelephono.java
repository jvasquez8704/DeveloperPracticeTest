package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Telephone;

public interface ITelephono extends JpaRepository<Telephone, Integer> {
	List<Telephone> findByIdEmployee(int idEmployee);
}
