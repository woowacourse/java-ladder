package laddergame.model;

import java.util.regex.Pattern;

public class Person {
    private final static int MIN_NAME_LENGTH = 1;
    private final static int MAX_NAME_LENGTH = 5;
    private final static String ERROR_NAME_IS_KOREAN = "참여자 이름에 한글이 포함되어서는 안됩니다.";
    private final static String ERROR_NAME_OUT_OF_LENGTH =
        "공백이 제거된 참여자 이름의 길이는 " + MIN_NAME_LENGTH + "보다 크고 " + MAX_NAME_LENGTH + "보다 작아야 합니다.";

    private final String name;

    public Person(String name) {
        validateKorean(name);
        validateTrimLength(name);
        this.name = name.trim();
    }

    private static void validateKorean(String name) {
        boolean isKorean = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        if (isKorean) {
            throw new IllegalArgumentException(ERROR_NAME_IS_KOREAN);
        }
    }

    private static void validateTrimLength(String name) {
        int nameLength = name.trim().length();
        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_OUT_OF_LENGTH);
        }
    }

    public String getName() {
        return this.name;
    }
}
