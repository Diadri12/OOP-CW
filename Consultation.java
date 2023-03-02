package SkinConsultationCenter;

import java.util.Date;

public class Consultation {
    private Date dateAndTimeSlot;
    private String cost;
    private String notes;

    public Date getDateAndTimeSlot() {

        return this.dateAndTimeSlot;
    }

    public void setDateAndTimeSlot(Date dateAndTimeSlot) {

        this.dateAndTimeSlot = dateAndTimeSlot;
    }

    public String getCost() {

        return this.cost;
    }

    public void setCost(String cost) {

        this.cost = cost;
    }

    public String getNotes() {

        return this.notes;
    }

    public void setNotes(String notes) {

        this.notes = notes;
    }
}
