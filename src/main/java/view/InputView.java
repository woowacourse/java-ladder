package view;

import util.ExceptionMessage;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readPlayerNames() {
        return scanner.nextLine();
    }

    public int readLadderHeight() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new IllegalStateException(ExceptionMessage.EXCEPTION_LADDER_HEIGHT.getExceptionMessage());
        }
    }

    public String readLadderResult(){
        return scanner.nextLine();
    }
}
