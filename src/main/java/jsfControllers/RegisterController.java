/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsfControllers;

import entity.Student;
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
public class RegisterController {
    private Student student;
    
    public String getRandomWord(){
        return "test";
    }

    public RegisterController() {
        this.student = new Student();
    }
    
    
    
    @Inject
    private Students students;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public String add(){
        students.addStudent(student);
        return "index.xhtml";
    }
    
    
    
    
    
}
