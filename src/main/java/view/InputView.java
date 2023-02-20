package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String DIGIT_ERROR_MESSAGE = "자연수만 입력 가능합니다.";
    private static final String HEIGHT_ERROR_MESSAGE= "사다리 높이는 1이상 100이하의 자연수만 가능합니다.";
    private static final String DELIMITER = ",";
    private static final String DIGIT_REGEX = "^[0-9]+$";

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNames() {
        printMessage(NAME_INPUT_MESSAGE);
        String inputNames = scanner.nextLine();
        return Arrays.stream(inputNames.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static int readLadderHeight() {
        printMessage(HEIGHT_INPUT_MESSAGE);
        String ladderHeight = scanner.nextLine();
        validateDigit(ladderHeight);
        validateHeightRange(Integer.parseInt(ladderHeight));
        return Integer.parseInt(ladderHeight);
    }

    private static void validateDigit(String ladderHeight) {
        if (!Pattern.matches(DIGIT_REGEX, ladderHeight)) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }

    private static void validateHeightRange(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
