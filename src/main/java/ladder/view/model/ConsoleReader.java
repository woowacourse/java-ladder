package ladder.view.model;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
