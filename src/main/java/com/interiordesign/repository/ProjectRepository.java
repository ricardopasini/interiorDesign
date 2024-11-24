package com.interiordesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interiordesign.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

}
