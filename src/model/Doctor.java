package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public void addAvailableAppointment(String date, String time){
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

    @Override
    public void showDataUser() {
        System.out.println("Empleado Hospital: Cruz Roja");
        System.out.println("Departamento: Oncologia");
    }

    // Nested Class
    public static class AvailableAppointment {
        private int id;
        private Date date; // Que fecha se encuentra disponible el doctor
        private String time; // hora
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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

        public String getDate(String DATE) {
            return format.format(date);
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
