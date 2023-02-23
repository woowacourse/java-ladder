package laddergame.util;

public class Validator {
    public static void checkNull(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("입력에는 공백이 들어올 수 없습니다");
        }
    }
}
