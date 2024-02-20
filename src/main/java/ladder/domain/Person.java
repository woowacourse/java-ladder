package ladder.domain;

public class Person {

    String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException("이름은 1~5글자 이내입니다.");
        }
    }
}
