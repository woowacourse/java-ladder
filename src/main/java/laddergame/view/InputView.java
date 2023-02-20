package laddergame.view;

import laddergame.constant.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]+[0-9]*$";

    public static List<String> inputPlayerNames() {
        String playerNames = SCANNER.nextLine();
        validateBlankInput(playerNames);
        return Arrays.asList(playerNames.split(SPLIT_DELIMITER));
    }

    public static List<String> inputLadderPrize() {
        String prizes = SCANNER.nextLine();
        validateBlankInput(prizes);
        return Arrays.asList(prizes.split(SPLIT_DELIMITER));
    }

    private static void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.getCode());
        }
    }

    public static int inputLadderHeight() {
        String ladderHeight = SCANNER.nextLine();
        validateNaturalNumber(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private static void validateNaturalNumber(String input) {
        if (!input.matches(NATURAL_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.NOT_NATURAL_NUMBER.getCode());
        }
    }
}
