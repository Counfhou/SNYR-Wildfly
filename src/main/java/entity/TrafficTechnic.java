/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author sande
 */
@Entity
public class TrafficTechnic {
    @Id
    @GeneratedValue
    private int trafficId;
    @ManyToOne
    private Student student;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="indicators_color")),
            @AttributeOverride(name="comment", column = @Column(name="indicators_comment"))
    }
    )
    private Status indicators;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="publicroad_color")),
            @AttributeOverride(name="comment", column = @Column(name="publicroad_comment"))
    }
    )
    private Status publicroad;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="priority_color")),
            @AttributeOverride(name="comment", column = @Column(name="priority_comment"))
    }
    )
    private Status priority;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="sign_color")),
            @AttributeOverride(name="comment", column = @Column(name="sign_comment"))
    }
    )
    private Status sign;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="speed_color")),
            @AttributeOverride(name="comment", column = @Column(name="speed_comment"))
    }
    )
    private Status speed;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="distance_color")),
            @AttributeOverride(name="comment", column = @Column(name="distance_comment"))
    }
    )
    private Status distance;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="overtaking_color")),
            @AttributeOverride(name="comment", column = @Column(name="overtaking_comment"))
    }
    )
    private Status overtaking;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="crossing_color")),
            @AttributeOverride(name="comment", column = @Column(name="crossing_comment"))
    }
    )
    private Status crossing;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="turningleft_color")),
            @AttributeOverride(name="comment", column = @Column(name="turningleft_comment"))
    }
    )
    private Status turningleft;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="color", column = @Column(name="turningright_color")),
            @AttributeOverride(name="comment", column = @Column(name="turningright_comment"))
    }
    )
    private Status turningright;

    public Status getIndicators() {
        return indicators;
    }

    public void setIndicators(Status indicators) {
        this.indicators = indicators;
    }

    public Status getPublicroad() {
        return publicroad;
    }

    public void setPublicroad(Status publicroad) {
        this.publicroad = publicroad;
    }

    public Status getPriority() {
        return priority;
    }

    public void setPriority(Status priority) {
        this.priority = priority;
    }

    public Status getSign() {
        return sign;
    }

    public void setSign(Status sign) {
        this.sign = sign;
    }

    public Status getSpeed() {
        return speed;
    }

    public void setSpeed(Status speed) {
        this.speed = speed;
    }

    public Status getDistance() {
        return distance;
    }

    public void setDistance(Status distance) {
        this.distance = distance;
    }

    public Status getOvertaking() {
        return overtaking;
    }

    public void setOvertaking(Status overtaking) {
        this.overtaking = overtaking;
    }

    public Status getCrossing() {
        return crossing;
    }

    public void setCrossing(Status crossing) {
        this.crossing = crossing;
    }

    public Status getTurningleft() {
        return turningleft;
    }

    public void setTurningleft(Status turningleft) {
        this.turningleft = turningleft;
    }

    public Status getTurningright() {
        return turningright;
    }

    public void setTurningright(Status turningright) {
        this.turningright = turningright;
    }

    public int getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(int trafficId) {
        this.trafficId = trafficId;
    }
    
    

    public TrafficTechnic(Status indicators, Status publicroad, Status priority, Status sign, Status speed, Status distance, Status overtaking, Status crossing, Status turningleft, Status turningright) {
        this.indicators = indicators;
        this.publicroad = publicroad;
        this.priority = priority;
        this.sign = sign;
        this.speed = speed;
        this.distance = distance;
        this.overtaking = overtaking;
        this.crossing = crossing;
        this.turningleft = turningleft;
        this.turningright = turningright;
    }
    
    /*copy constructor*/
    public TrafficTechnic(TrafficTechnic other){
        this.indicators = new Status(other.indicators);
        this.publicroad = new Status(other.publicroad);
        this.priority = new Status(other.priority);
        this.sign = new Status(other.sign);
        this.speed = new Status(other.speed);
        this.distance = new Status(other.distance);
        this.overtaking = new Status(other.overtaking);
        this.crossing = new Status(other.crossing);
        this.turningleft = new Status(other.turningleft);
        this.turningright = new Status(other.turningright);
    }
    
    public TrafficTechnic(){
        this.indicators = new Status();
        this.publicroad = new Status();
        this.priority = new Status();
        this.sign = new Status();
        this.speed = new Status();
        this.distance = new Status();
        this.overtaking = new Status();
        this.crossing = new Status();
        this.turningleft = new Status();
        this.turningright = new Status();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.trafficId;
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
        final TrafficTechnic other = (TrafficTechnic) obj;
        if (this.trafficId != other.trafficId) {
            return false;
        }
        return true;
    }
    
    
}
