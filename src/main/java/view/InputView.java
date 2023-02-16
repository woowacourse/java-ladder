package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static view.InputViewValidator.validateLadderHeight;
import static view.InputViewValidator.validatePlayerNames;

public class InputView {

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readPlayerNames() {
        String playerNamesInput = readline();
        validatePlayerNames(playerNamesInput);
        return Arrays.stream(playerNamesInput.split(",", -1))
                .map(String::strip)
                .collect(Collectors.toUnmodifiableList());
    }

    public int readLadderHeight() {
        // TODO : LadderHeigth, size 네이밍 맞추기
        String ladderHeight = readline();
        validateLadderHeight(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }

    private String readline() {
        return scanner.nextLine().strip();
    }
}
