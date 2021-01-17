package ui;

import model.Doctor;
import model.Patient;

import java.util.*;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;

        do {
            System.out.println("\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.userLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while(response != 0);
    }

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println(":: Select date:");
            // Numeracion de la lista de fechas
            // Indice fecha seleccionada
            // 1. Doctor#1
            // - - - 1. Fecha#1
            // - - - 2. Fecha#2
            // 2. Doctor#2
            // - - - 1. Fecha#1
            // - - - 2. Fecha#2
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            System.out.println("citas disponibles: " + UIDoctorMenu.doctorsAvailableAppointments);
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                List<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                Patient patientLogged = (Patient) UIMenu.userLogged;
                patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
            }

        } while(response != 0);
    }

    private static void showPatientMyAppointments() {
        int response = 0;
        do {
            System.out.println("::My Appointments");
            Patient patientLogged = (Patient) UIMenu.userLogged;
            if (patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                );

            }
            System.out.println("0. Return");
        } while (response != 0);
    }
}
