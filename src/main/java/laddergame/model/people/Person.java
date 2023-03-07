package laddergame.model.people;

import java.util.regex.Pattern;

public class Person {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validateKorean(name);
        validateTrimLength(name);
        this.name = name.trim();
    }

    private static void validateKorean(String name) {
        boolean isKorean = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        if (isKorean) {
            throw new IllegalArgumentException("참여자 이름에 한글이 포함되어서는 안됩니다.");
        }
    }

    private static void validateTrimLength(String name) {
        if (name.trim().length() < MIN_NAME_LENGTH || name.trim().length() > MAX_NAME_LENGTH) {
            String message = String.format("공백이 제거된 참여자 이름의 길이는 %d보다 크고 %d보다 작아야 합니다."
                    , MIN_NAME_LENGTH, MAX_NAME_LENGTH);
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return this.name;
    }
}
