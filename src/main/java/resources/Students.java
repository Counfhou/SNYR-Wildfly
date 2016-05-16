/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entity.Student;
import java.net.URI;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sande
 */
@Path("students")
@Transactional
public class Students 
{
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents ()
    {
        TypedQuery<Student> queryFindAllStudents = em.createNamedQuery("Student.findAll", Student.class);
        
        return queryFindAllStudents.getResultList();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent (Student student)
    {
     //   em.getTransaction().begin();
        em.persist(student);
     //   em.getTransaction().commit();
        
        return Response.created(URI.create("/" + student.getStudentnr())).build();
    }
    
    @Path("{studentId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("studentId") int studentId)
    {
        Student student = em.find(Student.class, studentId);
        
        if (student == null)
        {
            throw new NotFoundException("Student not found.");
        }
        
        return student;
    }
    
//    @Path("{studentId}")
//    @PUT
//    @Consumes (MediaType.APPLICATION_JSON)
//    public void updateUser(@PathParam("studentId") String studentId, InputStream input)
//    {
//        Student student = em.find(Student.class, studentId);
//        
//        if (student == null)
//        {
//            throw new NotFoundException("Student not found.");
//        }
//        
//        em.detach(student);
//        
//        try (JsonReader jsonInput = Json.createReader(input))
//        {
//            JsonObject jsonStudent = jsonInput.readObject();
//            
//            
//        }
//    }
    
    @Path("{studentId}")
    @DELETE
    public void removeStudent (@PathParam("studentId") int studentId)
    {
        Student student = em.find(Student.class, studentId);
        
        if (student == null) {
            throw new NotFoundException("Student not found.");
        }
        
        em.remove(student);
    }
}
