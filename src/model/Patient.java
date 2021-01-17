package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    // Attributes
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppointmentDoctor> appointmentDoctors;
    private ArrayList<AppointmentNurse> appointmentNurses;

    // Constructor
    public Patient(String name, String email) {
        super(name, email);
        appointmentDoctors = new ArrayList<>();
        appointmentNurses = new ArrayList<>();
    }

    public Patient(String name, String email, double weight) {
        super(name, email);
        this.weight = weight;
        appointmentDoctors = new ArrayList<>();
        appointmentNurses = new ArrayList<>();
    }

    // Getters and Setters
    public String getFormattedWeight() {
        return this.weight + " Kg.";
    }
    public String getFormattedHeight() {
        return this.height + " Mts.";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n birthday='" + birthday + '\'' +
                "\n weight=" + getFormattedWeight() +
                "\n height=" + getFormattedHeight() +
                "\n blood='" + blood + '\'';
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo");
    }
}
