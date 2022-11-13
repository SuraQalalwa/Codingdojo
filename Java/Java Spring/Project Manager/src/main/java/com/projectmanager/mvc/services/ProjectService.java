package com.projectmanager.mvc.services;

import com.projectmanager.mvc.models.Project;
import com.projectmanager.mvc.models.User;
import com.projectmanager.mvc.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
//    public Project findProject(Long id) {
//        return this.projectRepository.findById(id).orElse(null);
//    }

    public Project findProjectById(Long id) {
        return projectRepository.findProjectById(id);
    }
    public Project update(Project thisProject) {
        return projectRepository.save(thisProject);
    }
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public List<Project> projectNotLeader(User user){
        return projectRepository.findAllByUsersNotContains(user);
    }

    public List<Project> projectLeader(User user){
        return projectRepository.findAllByUsers(user);

    }

//    public void addUserToProject(User projectuser) {
//        if(this.Users.equals(null)) {
//            this.users=new ArrayList<User>();
//        }
//        this.projectUsers.add(projectuser);
//    }

}

