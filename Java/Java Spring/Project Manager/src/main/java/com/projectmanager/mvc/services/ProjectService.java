package com.projectmanager.mvc.services;

import com.projectmanager.mvc.models.Project;
import com.projectmanager.mvc.models.User;
import com.projectmanager.mvc.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
    @Autowired
    private  ProjectRepository projectRepository;
    public List<Project> allProject() {
        return  projectRepository.findAll();
    }
    public Project createProject(Project b) {
        return projectRepository.save(b);
    }
    public Project findProject(Long id) {
        return this.projectRepository.findById(id).orElse(null);
    }

    public Project findProjectById(Long id) {
        return projectRepository.findProjectById(id);
    }
    public List<Project> projectLeader(User user){
        return projectRepository.findAllByUsers(user);

    }

    public Project update(Project thisProject) {
        return projectRepository.save(thisProject);
    }

    public List<Project> projectNotLeader(User user){
        return projectRepository.findAllByUsersNotContains(user);
    }


    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}

