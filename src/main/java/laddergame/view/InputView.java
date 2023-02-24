package laddergame.view;

import laddergame.constant.ErrorCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";
    private static final String NATURAL_NUMBER_REGEX = "^[1-9]+[0-9]*$";

    public static List<String> inputPlayerNames() {
        String playerNames = SCANNER.nextLine();
        validateBlankInput(playerNames);
        return splitInput(playerNames);
    }

    public static List<String> inputLadderPrize() {
        String prizes = SCANNER.nextLine();
        validateBlankInput(prizes);
        return splitInput(prizes);
    }

    private static List<String> splitInput(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
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

    public static String inputResultShowPlayerName() {
        String name = SCANNER.nextLine();
        validateBlankInput(name);
        return name;
    }

    private static void validateNaturalNumber(String input) {
        if (!input.matches(NATURAL_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.NOT_NATURAL_NUMBER.getCode());
        }
    }
}
