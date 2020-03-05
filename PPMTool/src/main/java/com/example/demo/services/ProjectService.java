package com.example.demo.services;

import com.example.demo.domain.Project;
import com.example.demo.exceptions.ProjectIdException;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        //return project;

        catch (Exception ex) {
            throw new ProjectIdException("ProjectId" + project.getProjectIdentifier().toUpperCase() + " already exists");
        }
    }

    public Project findByProjectId(String projectIdentifier) {
       return  projectRepository.findByProjectIdentifier(projectIdentifier);
    }
    public Iterable<Project> findAllService(){
        return  projectRepository.findAll();
    }
   public void deleteProjectByIdentifier(String projectId){
        Project project=findByProjectId(projectId);
        if(project==null){
            throw new ProjectIdException ("Project with Id: "+projectId+" does not exists");
        }
        projectRepository.delete(project);
   }
   
}
