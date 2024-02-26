package view;

import common.exception.message.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final Scanner scanner;

    // TODO : 현재 정규식은 DELIMITER가 변경되어도 ","에 대해서만 확인하고 있음.
    public static final Pattern PLAYER_NAMES_INPUT_PATTERN = Pattern.compile("[가-힣a-zA-Z]{1,5}(,[가-힣a-zA-Z]{1,5})*");
    public static final String PLAYER_NAMES_INPUT_DELIMITER = ",";
    private static final String BLANK_SPACE = " ";
    private static final String BLANK_EMPTY = "";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        System.out.println(String.format("참여할 사람 이름을 입력하세요. (%s)로 구분하세요)", PLAYER_NAMES_INPUT_DELIMITER));
        String playerNamesInput = scanner.nextLine();
        playerNamesInput = playerNamesInput.replace(InputView.BLANK_SPACE, InputView.BLANK_EMPTY);
        validatePlayerNamesInput(playerNamesInput);
        return Arrays.stream(playerNamesInput.split(PLAYER_NAMES_INPUT_DELIMITER))
                .toList();
    }

    private void validatePlayerNamesInput(final String playerNamesInput) {
        if (!InputView.PLAYER_NAMES_INPUT_PATTERN.matcher(playerNamesInput).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAMES_INPUT_FORMAT);
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
            throw new IllegalArgumentException(ExceptionMessage.INTEGER_FORMAT);
        }
    }
}
