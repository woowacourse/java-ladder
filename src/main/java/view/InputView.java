package view;

import common.exception.model.IOException;
import view.command.Command;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String LADDER_RESULT_INPUT_FORMAT_ERROR_MESSAGE = String.format("사다리 실행 결과는 %s로 구분하여 입력해야합니다",
            InputView.LADDER_RESULTS_INPUT_DELIMITER);
    private static final String PLAYER_NAMES_INPUT_FORMAT_ERROR_MESSAGE = String.format("참가자 이름은 문자(영어 or 한글)이어야 하며 %s로 구분하여 입력해야합니다",
            InputView.PLAYER_NAMES_INPUT_DELIMITER);
    private static final String BANNED_PLAYER_NAMES_INPUT_ERROR_MESSAGE = "사용할 수 없는 이름이 포함되어 있습니다";
    private static final String INTEGER_FORMAT_ERROR_MESSAGE = "정수 형태만 입력 가능합니다";
    private static final String PLAYER_NAMES_INPUT_DELIMITER = ",";
    private static final String LADDER_RESULTS_INPUT_DELIMITER = ",";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] readPlayerNames() {
        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요", PLAYER_NAMES_INPUT_DELIMITER));
        String input = scanner.nextLine();

        validatePlayerNamesFormat(input);
        String[] playerNames = splitPlayerNames(input);
        validateIsNameDuplicatedWithCommand(playerNames);

        return playerNames;
    }

    private void validatePlayerNamesFormat(String playerNamesInput) {
        if (playerNamesInput.endsWith(PLAYER_NAMES_INPUT_DELIMITER)) {
            throw new IOException(PLAYER_NAMES_INPUT_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateIsNameDuplicatedWithCommand(String[] playerNames) {
        boolean isCommand = Arrays.stream(playerNames)
                .anyMatch(Command::isCommand);

        if (isCommand) {
            throw new IOException(BANNED_PLAYER_NAMES_INPUT_ERROR_MESSAGE);
        }
    }

    private String[] splitPlayerNames(String playerNamesInput) {
        playerNamesInput = playerNamesInput.replace(" ", "");
        return playerNamesInput.split(InputView.PLAYER_NAMES_INPUT_DELIMITER);
    }

    public String[] readLadderResults() {
        System.out.println(String.format("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", LADDER_RESULTS_INPUT_DELIMITER));
        String input = scanner.nextLine();

        validateLadderResultFormat(input);
        return splitLadderResults(input);
    }

    private String[] splitLadderResults(String playerNamesInput) {
        validateLadderResultFormat(playerNamesInput);
        playerNamesInput = playerNamesInput.replace(" ", "");
        return playerNamesInput.split(InputView.LADDER_RESULTS_INPUT_DELIMITER);
    }

    private void validateLadderResultFormat(String playerNamesInput) {
        if (playerNamesInput.endsWith(LADDER_RESULTS_INPUT_DELIMITER)) {
            throw new IOException(LADDER_RESULT_INPUT_FORMAT_ERROR_MESSAGE);
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
            throw new IOException(INTEGER_FORMAT_ERROR_MESSAGE);
        }
    }

    public String readPlayerNameForGetResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
