public class Doctor {
    static int autoId = 0; // Autoincrement
    int id;
    String name;
    String speciality;

    Doctor() {
        // this hace referencia a todos los elementos que componen la clase
        this.setId();
        // Cuando no se asignan valores a los atributos toman el valor por defecto
    }

    Doctor(String name, String speciality) {
        this.setId();
        this.name = name;
        this.speciality = speciality;
    }

    // Comportamientos
    public void showName() {
        System.out.println(name);
    }

    public void showId() {
        System.out.println("ID Doctor: " + id);
    }

    private void setId() {
        id = ++autoId;
    }
}
