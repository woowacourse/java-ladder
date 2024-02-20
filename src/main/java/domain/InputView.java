package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final InputValidator inputValidator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
    }

    public List<String> inputPlayers() {
        String input = scanner.nextLine();
        inputValidator.validatePlayers(input);
        String[] players = input.split(",");
        return Arrays.asList(players);
    }

    public int inputHeight() {
        String input = scanner.nextLine();
        inputValidator.validateHeight(input);
        return Integer.parseInt(input);
    }
}
