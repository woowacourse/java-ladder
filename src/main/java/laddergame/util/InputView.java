package laddergame.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_REWARD_NAMES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_WANT_RESULT = "결과를 보고 싶은 사람은?";
    private static final String SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        OutputView.outputMessage(INPUT_PLAYER_NAMES);
        return inputNames(SEPARATOR);
    }

    public static List<String> inputRewardNames() {
        OutputView.outputMessage(INPUT_REWARD_NAMES);
        return inputNames(SEPARATOR);
    }

    private static List<String> inputNames(String SEPARATOR) {
        try {
            String names = scanner.nextLine();
            Validator.checkEndsWithComma(names);
            return Arrays.stream(names.split(SEPARATOR))
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            OutputView.outputErrorMessage(e.getMessage());
            return inputPlayerNames();
        }
    }

    public static int inputHeight() {
        try {
            System.out.println(INPUT_HEIGHT);
            return Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            OutputView.outputErrorMessage(e.getMessage());
            return inputHeight();
        }
    }

    public static String inputWantResult() {
        System.out.println(INPUT_WANT_RESULT);
        return scanner.nextLine();
    }
}