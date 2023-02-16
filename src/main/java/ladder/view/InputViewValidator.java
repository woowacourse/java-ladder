package ladder.view;

public class InputViewValidator {

    private static final int MAX_NAMES_COUNT = 10000;
    private static final String NAMES_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참여자의 수는 10000명 이하여야합니다.";

    public static void validateNamesCount(int count) {
        if (count > MAX_NAMES_COUNT) {
            throw new IllegalArgumentException(NAMES_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
