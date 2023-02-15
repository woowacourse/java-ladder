package domain;

public class Person {

    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Person(String name){
        this.name = name;
        validateNameLength(name);
        validateNameBlank(name);
    }

    public String getName() {
        return name;
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()){
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
