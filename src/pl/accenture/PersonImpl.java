package pl.accenture;

public class PersonImpl implements Person {
    @Override
    public void go(String name) {
        System.out.println("Hej mam na imie " + name);
    }
}
