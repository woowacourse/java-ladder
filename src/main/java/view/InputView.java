package view;

import util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readPlayerNames() {
        String names = scanner.nextLine();
        return names;
    }

    public int readLadderHeight() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalStateException(ExceptionMessage.EXCEPTION_LADDER_HEIGHT.getExceptionMessage());
        }
    }
}
