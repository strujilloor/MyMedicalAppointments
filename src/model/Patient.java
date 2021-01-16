package model;

public class Patient extends User {
    // Attributes
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    // Constructor
    public Patient(String name, String email) {
        super(name, email);
    }

    public Patient(String name, String email, double weight) {
        super(name, email);
        this.weight = weight;
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
