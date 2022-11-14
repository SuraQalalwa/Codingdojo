package com.projectmanager.mvc.repositories;

import com.projectmanager.mvc.models.Project;
import com.projectmanager.mvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findAll();
    Project findProjectById(Long id);
    List<Project> findAllByUsers(User user);
    List<Project> findByUsersNotContains(User user);

}