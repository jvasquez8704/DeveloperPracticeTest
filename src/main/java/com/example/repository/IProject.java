package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Project;

public interface IProject extends JpaRepository<Project, Integer>{

}
