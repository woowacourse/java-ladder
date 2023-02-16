package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static view.InputViewValidator.validateLadderHeight;
import static view.InputViewValidator.validatePlayerNames;

public class InputView {

    public static final String INPUT_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        printInputMessage(INPUT_PLAYER_NAMES_MESSAGE);
        String playerNamesInput = readline();
        validatePlayerNames(playerNamesInput);
        return Arrays.stream(playerNamesInput.split(",", -1))
                .map(String::strip)
                .collect(Collectors.toUnmodifiableList());
    }

    public int readLadderHeight() {
        printInputMessage(INPUT_LADDER_HEIGHT_MESSAGE);
        String ladderHeight = readline();
        validateLadderHeight(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private void printInputMessage(final String message) {
        System.out.println(message);
    }

    private String readline() {
        return scanner.nextLine().strip();
    }
}
