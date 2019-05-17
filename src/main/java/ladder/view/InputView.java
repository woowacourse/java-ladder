package ladder.view;

import ladder.validator.InputValidator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String FIND_RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputNames() {
        try {
            System.out.println(INPUT_NAME_MESSAGE);
            String inputName = SCANNER.nextLine();
            InputValidator.checkValidName(inputName);
            return inputName;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    public static int inputHeight() {
        try {
            System.out.println(INPUT_HEIGHT_MESSAGE);
            int height = Integer.parseInt(SCANNER.nextLine());
            InputValidator.isLowerLimit(height);
            return height;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputHeight();
        }

    }

    public static String inputResultAll(List<String> names) {
        try {
            System.out.println(INPUT_RESULT_MESSAGE);
            String resultCandidate = SCANNER.nextLine();
            InputValidator.checkValidResultCandidate(names, resultCandidate);
            return resultCandidate;
        } catch (IllegalArgumentException e) {
            return inputResultAll(names);
        }
    }

    public static String findResultName(List<String> names) {
        try {
            System.out.println(FIND_RESULT_NAME_MESSAGE);
            String requestedName = SCANNER.nextLine();
            InputValidator.isNotContainName(names, requestedName);
            return requestedName;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return findResultName(names);
        }
    }
}
