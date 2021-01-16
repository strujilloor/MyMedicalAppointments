import model.Doctor;
import model.ISchedulable;
import model.Patient;
import model.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //showMenu();

        Doctor myDoctor = new Doctor("Stiven", "stiven@gmail.com");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        System.out.println(myDoctor);

        Patient patient = new Patient("Alejandra", "alejandra@gmail.com");
        patient.setWeight(54.6);
        patient.setPhoneNumber("123456789");

        System.out.println(patient);

        User user = new Doctor("Anahi", "ana@ana.com");
        user.showDataUser();

        User user1 = new User("Anahi", "ana@ana.com") {
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Hospital: Cruz Azul");
                System.out.println("Departamento: Dermatologia");
            }
        };
        user1.showDataUser();

        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };
    }
}
