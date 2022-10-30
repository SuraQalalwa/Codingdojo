package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class Physician extends User implements HIPAACompliantUser {
    private ArrayList<String> patientNotes;

    public Physician(Integer id) {
        super(id);
    }
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format("Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.getId());
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    @Override
    public boolean assignPin(int pin) {
        if (pin == 4){
            return false;}
        else {
            setPin(pin);
            return true;
        }

    }
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (confirmedAuthID == id){
            return true;
        }
        return false;
    }
}
