package pl.accenture;


public class Main {

    public static void main(String[] args) {
        //1. uzycie klasycznej implementacji
        uzyjImplementacjiInterfejsu(new VehicleImpl());
        // 2 klasa anonimowa
        uzyjImplementacjiInterfejsu(new Vehicle() {
            @Override
            public void ran() {
                System.out.println("Anonimowa implementacja interfejsu ");
            }
        });
        // 3 uzycie lambdy
        uzyjImplementacjiInterfejsu(() -> {
            System.out.println("Lambda implementujaca interfejs ");
        });
        //1. uzyj klasycznej implementacji
        Person p = new PersonImpl();
        uzyjImplementacji(p, "Maciek");
        // 2 klasa anonimowa
        uzyjImplementacji(new Person() {
            @Override
            public void go(String name) {
                System.out.println("Hej jaetem " + name);
            }
        }, "Asia");
        // 3 uzycie lambdy
        uzyjImplementacji(name-> { System.out.println("Hej jestem " + name); }, "Kasia");

    }

    static void uzyjImplementacjiInterfejsu(Vehicle v) {
        v.ran();
    }

    static void uzyjImplementacji(Person p, String s) {
        p.go(s);
    }
}