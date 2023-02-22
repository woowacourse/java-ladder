package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView implements Input{

    private static final String INPUT_REWARDS_MESSAGE = "실행 결과를 입력하세요.";
    private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_TARGET_NAMES_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_CONTINUE_MESSAGE = "다른 결과를 출력하시겠습니까? (y/n)";
    private static final String DELIMITER = ",";

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public List<String> inputPlayerNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        String input = sc.nextLine();
        validateNull(input);

        return splitInputByDelimiter(input);
    }

    @Override
    public int inputHeightOfLadder() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        try {
            String input = sc.nextLine();
            validateNull(input);

            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }

    @Override
    public List<String> inputRewards() {
        System.out.println(INPUT_REWARDS_MESSAGE);
        String input = sc.nextLine();
        validateNull(input);

        return splitInputByDelimiter(input);
    }

    @Override
    public List<String> inputTargetPlayerNames() {
        System.out.println(INPUT_TARGET_NAMES_MESSAGE);
        String input = sc.nextLine();
        validateNull(input);

        return splitInputByDelimiter(input);
    }

    @Override
    public String inputContinue() {
        System.out.println(INPUT_CONTINUE_MESSAGE);
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
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

}
