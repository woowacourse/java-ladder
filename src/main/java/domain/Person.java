package domain;

public class Person {
    private final Name name;

    public Person(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
