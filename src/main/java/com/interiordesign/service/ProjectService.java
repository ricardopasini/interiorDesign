package com.interiordesign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interiordesign.model.Project;
import com.interiordesign.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project createProject(Project project) {
        project.setDateCreated(java.time.LocalDate.now());
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = getProjectById(id);
        existingProject.setTitle(updatedProject.getTitle());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setImageUrl(updatedProject.getImageUrl());
        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}