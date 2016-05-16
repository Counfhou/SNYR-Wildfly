package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

/**
 *
 * @author Yoran
 */
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
})
@Entity // Geen finals, @Id, Default const
public class Student 
{
    @Id // @Id (@Entity)
    @GeneratedValue
    private int studentnr;
    
    private String voornaam;
    private String achternaam;
    private String email;
    private String fotoURL;
    
    private final static int AANTALEVALUTIES=3;
    
    private int evanumber; /*hoeveeste evaluatie dit is*/
    @ElementCollection
    private List<Boolean> evasDone = new ArrayList<>(AANTALEVALUTIES);
    /*boolean array die bij houdt of een evaluatie al is gebruikt*/

    
  //  
    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL})
    private List<Skills> skills = new ArrayList<>(AANTALEVALUTIES); /*arrays die de verschillende skills bijhouden*/
    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL})
    private List<DriveTechnic> drivetechnics = new ArrayList<>(AANTALEVALUTIES);
    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL})
    private List<TrafficTechnic>  traffictechnics = new ArrayList<>(AANTALEVALUTIES);
   
    @ElementCollection
    List<String> attitudes = new ArrayList<>(AANTALEVALUTIES);
    @ElementCollection
    private List<Double> progreses = new ArrayList<>(AANTALEVALUTIES);
    /*progress van de progressbar/abx level*/
    
    public Student(){} // Default const (@Entity)
    
    public Student(String voornaam, String achternaam, String email, String fotoURL)
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.fotoURL = fotoURL;
        evanumber=0;
        for(int i=0;i<drivetechnics.size();i++){
            drivetechnics.set(i, new DriveTechnic());
        }
//        for(int i=0;i<skills.size();i++){
//            skills.set(i, new Skills());
//        }
        for(int i=0;i<traffictechnics.size();i++){
            traffictechnics.set(i, new TrafficTechnic());
        }
        for(int i=0;i<attitudes.size();i++){
            attitudes.set(i, "");
        }
        for(int i=0;i<evasDone.size();i++){
            evasDone.set(i, false);
        }
        for(int i=0;i<progreses.size();i++){
            progreses.set(i, 0.0);
        }
        /*eerste eva wordt nu sowieso open gedaan dus true*/
        evasDone.set(0, true);
    }

//    public Student(String voornaam, String achternaam, String email, String fotoURL, int evanumber, List<Skills> skills,List<DriveTechnic> drivetechnics,List<TrafficTechnic> traffictechnics,List<Boolean> evasDone) {
//        this.voornaam = voornaam;
//        this.achternaam = achternaam;
//        this.email = email;
//        this.fotoURL = fotoURL;
//        this.evanumber = evanumber;
//        this.traffictechnics=traffictechnics;
//        this.drivetechnics=drivetechnics;
//        this.skills=skills;
//        this.evasDone=evasDone;
//    }
    
    public int getStudentnr() {
        return studentnr;
    }

    public void setStudentnr(int studentnr) {
        this.studentnr = studentnr;
    }
    
    public List<Double> getProgreses() {
        return progreses;
    }
    
    public void setProgreses(Double[] progreses) {
        this.progreses.clear();
        for(Double p : progreses){
            this.progreses.add(p);
        }
    }

    public void setProgreses(List<Double> progreses) {
        this.progreses = progreses;
    }
    
    public double getCurrentProgres(){
        return progreses.get(evanumber);
    }
    
    public void setCurrentProgres(double i){
        progreses.set(evanumber, i);
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public List<Skills> getSkills() {
        return skills;
    }
    
    public void setSkills(Skills[] skills){
        this.skills.clear();
        this.skills.addAll(Arrays.asList(skills));
    }

    public void setSkills(List<Skills> evaluatie) {
        this.skills = evaluatie;
    }
    

    public List<DriveTechnic> getDriveTechnics() {
        return drivetechnics;
    }
    public DriveTechnic getCurrentDriveTechnic(){
        return drivetechnics.get(evanumber);
    }

    public void setDriveTechnics(DriveTechnic[] drive){
        this.drivetechnics.clear();
        this.drivetechnics.addAll(Arrays.asList(drive));
    }
    
    public void setDriveTechnics(List<DriveTechnic> rijtechniek) {
        this.drivetechnics = rijtechniek;
    }

    public List<TrafficTechnic> getTrafficTechnics() {
        return traffictechnics;
    }
    public TrafficTechnic getCurrentTrafficTechnic(){
        return traffictechnics.get(evanumber);
    }
    public void setTrafficTechnics(TrafficTechnic[] trafic){
        this.traffictechnics.clear();
        this.traffictechnics.addAll(Arrays.asList(trafic));
    }
    
    public void setTrafficTechnics(List<TrafficTechnic> verkeerstechniek) {
        this.traffictechnics = verkeerstechniek;
    }

    public List<String> getAttitudes() {
        return attitudes;
    }
    
    public String getCurrentAttitude(){
        return attitudes.get(evanumber);
    }

    public void setAttitudes(String[] Attitudes) {
        attitudes.clear();
        attitudes.addAll(Arrays.asList(Attitudes));
    }
    
    public void setAttitudes(List<String> Attitudes) {
        this.attitudes = Attitudes;
    }
    public void setCurrentAttitude(String attitude){
        attitudes.set(evanumber, attitude);
    }
    
    public int getEvanumber() {
        return evanumber;
    }

    public void setEvanumber(int newevanumber) {
        /*bij setten kijken of de evaluatie al gedaan is, indien nog niet huidig proces kopieren*/
//        if(!evasDone.get(newevanumber)){
//           /*kopieren door copy constructor*/
//           drivetechnics.set(newevanumber, new DriveTechnic(drivetechnics.get(evanumber)));
//           traffictechnics.set(newevanumber, new TrafficTechnic(traffictechnics.get(evanumber)));
//           skills.set(newevanumber, new Skills(skills.get(evanumber)));
//           attitudes.set(newevanumber, attitudes.get(evanumber));
//           progreses.set(newevanumber, progreses.get(evanumber));
//           /*we beginnen aan de nieuwe dus op true*/
//           evasDone.set(newevanumber, true);
//        }
        evanumber = newevanumber;
    }
    
    public List<Boolean> getEvasDone() {
        return evasDone;
    }

    public void setEvasDone(List<Boolean> evasDone) {
        this.evasDone = evasDone;
    }

    public List<DriveTechnic> getDrivetechnics() {
        return drivetechnics;
    }

    public void setDrivetechnics(List<DriveTechnic> drivetechnics) {
        this.drivetechnics = drivetechnics;
    }

    public List<TrafficTechnic> getTraffictechnics() {
        return traffictechnics;
    }

    public void setTraffictechnics(List<TrafficTechnic> traffictechnics) {
        this.traffictechnics = traffictechnics;
    }


    
    @Override
    public String toString(){
        return achternaam+" "+voornaam;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.studentnr;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentnr != other.studentnr) {
            return false;
        }
        return true;
    }
    
}
