package enumerations;

enum Day {
    MONDAY("Lunes"),
    TUESDAY("Jueves"),
    FRIDAY("Viernes"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo");

    // atributos
    private String spanish;

    // constructores
    Day(String s) {
        spanish = s;
    }

    // metodos
    public String getSpanish() {
        return spanish;
    }
}

public class TestEnums {
    public static void main(String[] args) {
        System.out.println(Day.SUNDAY.getSpanish());
    }
}
