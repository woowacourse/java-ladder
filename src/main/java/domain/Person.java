package domain;

public class Person {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Person(String name){
        this.name = name;
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }


}
