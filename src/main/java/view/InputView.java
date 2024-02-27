package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final String BLANK_EXCEPTION_MESSAGE = "[ERROR] 빈 값은 입력할 수 없습니다.";
    private static final String SPACE_EXCEPTION_MESSAGE = "[ERROR] 공백은 포함될 수 없습니다.";
    private static final String INVALID_CHARACTER_EXCEPTION_MESSAGE = "[ERROR] 영어, 한글, 숫자 및 쉼표만 입력 가능합니다.";
    private static final String NUMERIC_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";

    private static final String DEFAULT_DELIMITER = ",";
    private static final Pattern VALID_CHARACTER_PATTERN = Pattern.compile("[^a-zA-Z가-힣\\d" + DEFAULT_DELIMITER + "]");
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String rawNames = scanner.nextLine();
        validateStringWithDelimiter(rawNames);

        return Arrays.asList(rawNames.split(DEFAULT_DELIMITER, -1));
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String rawResults = scanner.nextLine();
        validateStringWithDelimiter(rawResults);

        return Arrays.asList(rawResults.split(DEFAULT_DELIMITER, -1));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        String rawHeight = scanner.nextLine();
        validateHeight(rawHeight);

        return Integer.parseInt(rawHeight);
    }

    private static void validateStringWithDelimiter(String input) {
        validateBlank(input);
        validateContainsSpace(input);
        validatePattern(input);
    }

    private static void validateHeight(String input) {
        validateBlank(input);
        validateContainsSpace(input);
        validateNumeric(input);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_EXCEPTION_MESSAGE);
        }
    }

    private static void validateContainsSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(SPACE_EXCEPTION_MESSAGE);
        }
    }

    private static void validatePattern(String input) {
        if (VALID_CHARACTER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_CHARACTER_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_EXCEPTION_MESSAGE);
        }
    }
}
