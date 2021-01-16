package model;

public abstract class User {
    static int autoId = 0; // Autoincrement
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        addAndAutoincrementId();
    }

    public void addAndAutoincrementId() {
        this.id = ++autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 8) {
            System.out.println("El numero telefonico debe ser de 8 digitos maximo");
        } else if (phoneNumber.length() == 8) {
            this.phoneNumber = phoneNumber;
        }
    }

    public void showName() {
        System.out.println("Name: " + name);
    }

    public void showId() {
        System.out.println("ID : " + id);
    }

    @Override
    public String toString() {
        return "User: " +
                "\n id=" + id +
                "\n name='" + name + '\'' +
                "\n email='" + email + '\'' +
                "\n address='" + address + '\'' +
                "\n phoneNumber='" + phoneNumber + '\'';
    }

    public abstract void showDataUser();
}
