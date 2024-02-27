package view;

import domain.result.message.ResultExceptionMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import view.message.InputExceptionMessage;

public class InputView {
    public static final String INPUT_DELIMITER = ",";
    private static final String BLANK_SPACE = " ";
    private static final String BLANK_EMPTY = "";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요)", INPUT_DELIMITER));
        String playerNamesInput = scanner.nextLine();
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);
        validatePlayerNamesInput(playerNamesInput);
        return Arrays.stream(playerNamesInput.split(INPUT_DELIMITER))
                .toList();
    }

    private void validatePlayerNamesInput(final String playerNamesInput) {
        if (!playerNamesInput.contains(INPUT_DELIMITER)) {
            throw new IllegalArgumentException(InputExceptionMessage.PLAYER_NAMES_INPUT_FORMAT);
        }
    }

    public int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String ladderHeight = scanner.nextLine();
        validateIntegerFormat(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private void validateIntegerFormat(final String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(InputExceptionMessage.INTEGER_FORMAT);
        }
    }

    public List<String> readLadderResult() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String ladderResult = scanner.nextLine();
        validateLadderResultInput(ladderResult);
        return Arrays.stream(ladderResult.split(INPUT_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private void validateLadderResultInput(String ladderResult) {
        if (!ladderResult.contains(INPUT_DELIMITER)) {
            throw new IllegalArgumentException(ResultExceptionMessage.LADDER_RESULT_INPUT_FORMAT);
        }
    }
}
