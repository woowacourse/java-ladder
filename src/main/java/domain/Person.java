package domain;

public class Person {
    Name name;

    public Person(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
