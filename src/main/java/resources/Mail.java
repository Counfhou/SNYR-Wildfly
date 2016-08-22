/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import entity.Student;
import java.net.URI;
import java.util.Properties;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yoran
 */

@Path("mail")
@Transactional
public class Mail {
    
    @PersistenceContext
    private EntityManager em;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sendMail(int studentId)
    {
        Student student = em.find(Student.class, studentId);
        
        String to = student.getEmail();
        String from = "evaluata@gmail.com";
        // Assuming you are sending email from localhost
        String host = "localhost";
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                                      new InternetAddress(to));

            message.setSubject("This is the Subject Line!");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is message body");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "file.txt";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            
//            props.setProperty("mail.user", "myuser");
//            props.setProperty("mail.password", "mypwd");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return Response.created(URI.create("/" + Integer.toString(studentId))).build();
    }
    
}
