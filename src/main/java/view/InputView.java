package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String DIGIT_ERROR_MESSAGE = "자연수만 입력 가능합니다.";
    private static final String NAME_ERROR_MESSAGE = "이름은 1자 이상 5자 이하만 가능합니다.";
    private static final String DELIMITER = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        printMessage(NAME_INPUT_MESSAGE);
        String inputNames = scanner.nextLine();
        return Arrays.stream(inputNames.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static List<String> readPrizes() {
        printMessage(RESULT_INPUT_MESSAGE);
        String inputResults = scanner.nextLine();
        return Arrays.stream(inputResults.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static int readLadderHeight() {
        printMessage(HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine();
        validateDigit(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    public static String readResultName() {
        printMessage(RESULT_NAME_MESSAGE);
        String resultName = scanner.nextLine();
        if (resultName.isBlank()) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
        return resultName;
    }

    private static void validateDigit(String ladderHeight) {
        if (!Pattern.matches(DIGIT_REGEX, ladderHeight)) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
