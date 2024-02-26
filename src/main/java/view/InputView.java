package view;

import common.exception.message.ExceptionMessage;
import common.exception.model.IOException;

import java.util.Scanner;

public class InputView {
    public static final String PLAYER_NAMES_INPUT_DELIMITER = ",";
    public static final String LADDER_RESULTS_INPUT_DELIMITER = ",";
    public static final String BLANK_SPACE = " ";
    public static final String BLANK_EMPTY = "";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] readPlayerNames() {
        String input = scanner.nextLine();
        validatePlayerNamesFormat(input);

        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요", PLAYER_NAMES_INPUT_DELIMITER));
        return splitPlayerNames(input);
    }

    private void validatePlayerNamesFormat(String playerNamesInput) {
        if(playerNamesInput.endsWith(PLAYER_NAMES_INPUT_DELIMITER)) {
            throw new IOException(ExceptionMessage.PLAYER_NAMES_FORMAT);
        }
    }

    private String[] splitPlayerNames(String playerNamesInput) {
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);
        return playerNamesInput.split(InputView.PLAYER_NAMES_INPUT_DELIMITER);
    }

    public String[] readLadderResults() {
        String input = scanner.nextLine();
        validateLadderResultFormat(input);

        System.out.println(String.format("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", LADDER_RESULTS_INPUT_DELIMITER));
        return splitLadderResults(input);
    }

    private String[] splitLadderResults(String playerNamesInput) {
        validateLadderResultFormat(playerNamesInput);
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);
        return playerNamesInput.split(InputView.LADDER_RESULTS_INPUT_DELIMITER);
    }

    private void validateLadderResultFormat(String playerNamesInput) {
        if(playerNamesInput.endsWith(LADDER_RESULTS_INPUT_DELIMITER)) {
            throw new IOException(ExceptionMessage.LADDER_RESULT_FORMAT);
        }
    }

    public int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();

        validateIntFormat(input);
        return Integer.parseInt(input);
    }

    private void validateIntFormat(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IOException(ExceptionMessage.INTEGER_FORMAT);
        }
    }
}
