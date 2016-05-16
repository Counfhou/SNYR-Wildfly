package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Yoran
 */
@Entity
public class Skills 
{
    @Id
    @GeneratedValue
    private int skillId;
    
    
    @ManyToOne
    private Student student;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="fueling_color")),
            @AttributeOverride(name="comment", column = @Column(name="fueling_comment"))
    }
    )
    private Status fueling;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="gps_color")),
            @AttributeOverride(name="comment", column = @Column(name="gps_comment"))
    }
    )
    private Status gps;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="tires_color")),
            @AttributeOverride(name="comment", column = @Column(name="tires_comment"))
    }
    )
    private Status tires;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="emergencystop_color")),
            @AttributeOverride(name="comment", column = @Column(name="emergencystop_comment"))
    }
    )
    private Status emergencystop;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="city_color")),
            @AttributeOverride(name="comment", column = @Column(name="city_comment"))
    }
    )
    private Status city;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="doublelane_color")),
            @AttributeOverride(name="comment", column = @Column(name="doublelane_comment"))
    }
    )
    private Status doublelane;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="lights_color")),
            @AttributeOverride(name="comment", column = @Column(name="lights_comment"))
    }
    )
    private Status lights;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="oilcheck_color")),
            @AttributeOverride(name="comment", column = @Column(name="oilcheck_comment"))
    }
    )
    private Status oilcheck;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="roundabout_color")),
            @AttributeOverride(name="comment", column = @Column(name="roundabout_comment"))
    }
    )
    private Status roundabout;
    
    @Embedded
     @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="highway_color")),
            @AttributeOverride(name="comment", column = @Column(name="highway_comment"))
    }
    )
    private Status highway;

    public Status getFueling() {
        return fueling;
    }

    public void setFueling(Status fueling) {
        this.fueling = fueling;
    }

    public Status getGps() {
        return gps;
    }

    public void setGps(Status gps) {
        this.gps = gps;
    }

    public Status getTires() {
        return tires;
    }

    public void setTires(Status tires) {
        this.tires = tires;
    }

    public Status getEmergencystop() {
        return emergencystop;
    }

    public void setEmergencystop(Status emergencystop) {
        this.emergencystop = emergencystop;
    }

    public Status getCity() {
        return city;
    }

    public void setCity(Status city) {
        this.city = city;
    }

    public Status getDoublelane() {
        return doublelane;
    }

    public void setDoublelane(Status doublelane) {
        this.doublelane = doublelane;
    }

    public Status getLights() {
        return lights;
    }

    public void setLights(Status lights) {
        this.lights = lights;
    }

    public Status getOilcheck() {
        return oilcheck;
    }

    public void setOilcheck(Status oilcheck) {
        this.oilcheck = oilcheck;
    }

    public Status getRoundabout() {
        return roundabout;
    }

    public void setRoundabout(Status roundabout) {
        this.roundabout = roundabout;
    }

    public Status getHighway() {
        return highway;
    }

    public void setHighway(Status highway) {
        this.highway = highway;
    }

    public Skills(Status fueling, Status gps, Status tires, Status emergencystop, Status citytraffic, Status doublelane, Status lights, Status oilcheck, Status roundabout, Status highway) {
        this.fueling = fueling;
        this.gps = gps;
        this.tires = tires;
        this.emergencystop = emergencystop;
        this.city = citytraffic;
        this.doublelane = doublelane;
        this.lights = lights;
        this.oilcheck = oilcheck;
        this.roundabout = roundabout;
        this.highway = highway;
    }
    
    public Skills(Skills other){ // deep copy constructor
        this.city = new Status(other.city);
        this.doublelane = new Status(other.doublelane);
        this.emergencystop = new Status(other.emergencystop);
        this.fueling = new Status(other.fueling);
        this.gps = new Status(other.gps);
        this.highway = new Status(other.highway);
        this.lights = new Status(other.lights);
        this.oilcheck = new Status(other.oilcheck);
        this.roundabout = new Status(other.roundabout);
        this.tires = new Status(other.tires);
    }
    
    public Skills(){
        this.city = new Status();
        this.doublelane = new Status();
        this.emergencystop = new Status();
        this.fueling = new Status();
        this.gps = new Status();
        this.highway = new Status();
        this.lights = new Status();
        this.oilcheck = new Status();
        this.roundabout = new Status();
        this.tires = new Status();
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.skillId;
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
        final Skills other = (Skills) obj;
        if (this.skillId != other.skillId) {
            return false;
        }
        return true;
    }
}
