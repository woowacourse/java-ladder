package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String read(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
