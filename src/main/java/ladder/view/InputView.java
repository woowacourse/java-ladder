package ladder.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PLAYERS_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NAME_DELIMITER = ",";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String HEIGHT_ERROR_MESSAGE = "사다리 높이는 자연수만 입력할 수 있습니다.";
    private static final String PRIZES_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String RESULT_COMMAND_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
    public List<String> inputPlayers() {
        System.out.println(PLAYERS_INPUT_MESSAGE);
        String names = scanner.nextLine();
        return List.of(names.split(NAME_DELIMITER));
    }

    public int inputHeight() {
        System.out.println(HEIGHT_INPUT_MESSAGE);
        return inputNumericHeight();
    }

    private int inputNumericHeight() {
        int height;
        try {
            height = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
        scanner.nextLine();
        return height;
    }

    public List<String> inputPrizes() {
        System.out.println(PRIZES_INPUT_MESSAGE);
        String names = scanner.nextLine();
        return List.of(names.split(NAME_DELIMITER));
    }

    public String inputPlayerForResult() {
        System.out.println(RESULT_COMMAND_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
