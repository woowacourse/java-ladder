package laddervalidate;

import java.util.regex.Pattern;

public class HeightValidator {
    public void checkNumberMissMatch(String height) {
        if (!Pattern.matches("^[0-9]*$", height)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public void checkNegativeNumber(String height) {
        if (Integer.parseInt(height) <= 0) {
            throw new IllegalArgumentException("양의 정수만 입력해주세요.");
        }
    }
}
