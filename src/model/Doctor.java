package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    // Atributos
    private String speciality;
    ArrayList<AvailableAppointment> availableAppointments;

    // Constructor
    public Doctor(String name, String email) {
        super(name, email);
        availableAppointments = new ArrayList<>();
    }

    // Comportamientos
    public void addAvailableAppointment(Date date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Speciality='" + speciality + '\'' +
                "\n Available=" + availableAppointments.toString();
    }

    // Nested Class
    public static class AvailableAppointment {
        private int id;
        private Date date; // Que fecha se encuentra disponible el doctor
        private String time; // hora

        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointment:" +
                    "\n Date = " + date +
                    "\n Time = " + time;
        }
    }


}
