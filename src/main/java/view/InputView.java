package view;

import common.exception.message.ExceptionMessage;
import common.exception.model.IOException;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public static final String PLAYER_NAMES_INPUT_DELIMITER = ",";
    public static final String BLANK_SPACE = " ";
    public static final String BLANK_EMPTY = "";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] readPlayerNames() {
        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요", PLAYER_NAMES_INPUT_DELIMITER));
        return splitPlayerNames(scanner.nextLine());
    }

    private String[] splitPlayerNames(String playerNamesInput) {
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);
        return playerNamesInput.split(InputView.PLAYER_NAMES_INPUT_DELIMITER);
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
