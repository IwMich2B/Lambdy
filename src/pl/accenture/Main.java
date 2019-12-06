package pl.accenture;


import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

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
        uzyjImplementacji(name -> {
            System.out.println("Hej jestem " + name);
        }, "Kasia");

        wydrukDokumentow(dokument -> {
            System.out.println("Planowany wydruk na dzisiaj to : " + dokument);
        }, "Pan Tadeusz");
        String przerabiam = "Lambdy";
        String przerobione;
        //   wydrukDokumentow(przerobione,p-> przerabiam.toUpperCase());

        BinaryOperator<String> binaryOperator = (x, y) -> x + y;
        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;

        concat((x, y) -> x + y, "10", "20");
        add((x, y) -> x + y, "10", "20");

        concat(binaryOperator, "10", "20");
        add(intBinaryOperator, "10", "20");
        System.out.println("Moja implementacja");

        concat((a, b) -> a + b, "33", "66");
        concat(binaryOperator, "33", "66");
        // lambda 5
        System.out.println("Cwiczenia na dwa sposoby");
        boolean isLessThan10 = usePredicate(stringMniejszy, "Ala ma kota");
        boolean isLessThan = usePredicate(s->s.length()< 10, "Ala ma kota");
        boolean isBigThan10 = usePredicate(stringWiekszy, "Ala ma kota");
        boolean isBigThan = usePredicate(s ->s.length()>10, "Ala ma kota");
        boolean isequals10 = usePredicate(stringRowny, "Ala ma kota");
        boolean isequal = usePredicate(s->s.length()==10, "Ala ma kota");
        System.out.println("Is less than 10:" + isLessThan10);
        System.out.println("Is less than 10:" + isLessThan);
        System.out.println("Is big than 10:" + isBigThan10);
        System.out.println("Is big than 10:" + isBigThan);
        System.out.println("Is equals than 10:" + isequals10);
        System.out.println("Is equals than 10:" + isequal);


    }

    static void uzyjImplementacjiInterfejsu(Vehicle v) {
        v.ran();
    }

    static void uzyjImplementacji(Person p, String s) {
        p.go(s);
    }

    static void wydrukDokumentow(Drukarnia d, String p) {
        d.print(p);
    }

    static void concat(BinaryOperator<String> binaryOperator, String s1, String s2) {
        String result = binaryOperator.apply(s1, s2);
        System.out.println(result);
    }

    static void add(IntBinaryOperator intBinaryOperator, String s1, String s2) {
        int result = intBinaryOperator.applyAsInt(Integer.valueOf(s1), Integer.valueOf(s2));
        System.out.println(result);
    }

    static Predicate<String> stringMniejszy = s -> s.length() < 10;
    static Predicate<String> stringWiekszy = s -> s.length() > 10;
    static Predicate<String> stringRowny = s -> s.length() == 10;
    static Predicate<String> predicate = s -> s.length() < 10;

    static boolean usePredicate(Predicate<String> p, String value) {
        return p.test(value);
    }
}

 /*
             Wyrażenie lambda nie posiada konkretnego typu, a to oznacza, że nie może wystę̨pować
             'samodzielnie' (Java jest ję̨zykiem ściśle ́typowanym)

             Typ wyrażenia lambda jest zawsze wnioskowany przez kompilator na podstawie kontekstu jego użycia –
            jest on okreś́lony przez interfejs funkcyjny

            Utworzymy dwie metody:

             static void concat(BinaryOperator<String> binaryOperator, String s1, String s2)
             static void add(IntBinaryOperator intBinaryOperator, String s1, String s2)

            Ta sama lambda:

            (x, y) -> x + y

            Będzie oznaczała konkatenację lub dodawanie, w zależności od kontekstu jej użycia (do której
            metody ją przekażemy).

            concat - implementacja BinaryOperator<String> binaryOperator
            add - implementacja IntBinaryOperator intBinaryOperator


         */
