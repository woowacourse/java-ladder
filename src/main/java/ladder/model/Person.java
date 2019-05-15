package ladder.model;

public class Person implements Comparable<Person> {
    static final int NAME_MIN_LENGTH = 1;
    static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Person(String name) {
        name = name.trim();
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getNameLength() {
        return name.length();
    }

    @Override
    public int compareTo(Person rhs) {
        return name.length() - rhs.name.length();
    }
    
    @Override
    public String toString() {
        return name;
    }
}