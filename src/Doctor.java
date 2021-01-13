public class Doctor {
    static int autoId = 0; // Autoincrement
    int id;
    String name;
    String speciality;

    Doctor() {
        id = ++autoId;
    }

    Doctor(String name) {
        System.out.println("El nombre del Doctor asignado es: " + name);
    }

    // Comportamientos
    public void showName() {
        System.out.println(name);
    }

    public void showId() {
        System.out.println("ID Doctor: " + id);
    }
}
