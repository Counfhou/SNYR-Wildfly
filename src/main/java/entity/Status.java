package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Yoran
 */
@Embeddable
public class Status 
{
    //@Column(insertable = false,updatable = false)
    private Color color;
    //@Column(insertable = false,updatable = false)
    private String comment;

    public Status(Color color, String comment) {
        this.color = color;
        this.comment = comment;
    }
    public Status(){
        this.color=color.WHITE;
        this.comment="";
    }
    
    /*copy constructor*/
    public Status(Status other){
        this.color=other.color;
        this.comment=other.comment;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String commentaar) {
        this.comment = commentaar;
    }
    
    
    
}
