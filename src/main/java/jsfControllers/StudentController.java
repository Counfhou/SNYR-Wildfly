/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfControllers;

import entity.Student;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import resources.Students;

/**
 *
 * @author sande
 */
@Named
@RequestScoped
public class StudentController {
    
    private List<Student> studentlist;
    
    @Inject
    private Students students;
    
    @PostConstruct
    public void init(){
        studentlist=students.getAllStudents();
    }
    
    public List<Student> getStudentlist(){
        return studentlist;
    }

    public void setStudentlist(List<Student> studentlist) {
        this.studentlist = studentlist;
    }
    
    
    
}
