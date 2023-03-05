package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_REWARDS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String ERROR_NOT_NUMBER_MESSAGE = "숫자를 입력하세요.";
    private static final String ERROR_NULL_OR_BLANK_MESSAGE = "값을 입력해주세요.";

    private static final String DELIMITER = ",";

    private static final Scanner sc = new Scanner(System.in);

    private List<String> inputListOfSomething(String inputMessage) {
        System.out.println(inputMessage);
        String input = sc.nextLine();
        validateNull(input);

        return splitInputByDelimiter(input);
    }


    public List<String> inputPlayerNames() {
        return inputListOfSomething(INPUT_NAMES_MESSAGE);
    }

    public List<String> inputRewards() {
        return inputListOfSomething(INPUT_REWARDS_MESSAGE);
    }

    public int inputHeightOfLadder() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        try {
            String input = sc.nextLine();
            validateNull(input);

            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE);
        }
    }

    public String inputRequestForResult() {
        System.out.println(INPUT_RESULT_MESSAGE);
        String input = sc.nextLine();
        validateNull(input);

        return input;
    }

    private List<String> splitInputByDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL_OR_BLANK_MESSAGE);
        }
    }

}
