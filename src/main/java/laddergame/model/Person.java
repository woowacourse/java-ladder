package laddergame.model;

import java.util.regex.Pattern;

public class Person {
    String name;

    public Person(String name) {
        boolean isKorean = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        if (isKorean) {
            throw new IllegalArgumentException();
        }
        if (name.trim().length() < 1 || name.trim().length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name.trim();
    }

    public String getName() {
        return this.name;
    }
}
