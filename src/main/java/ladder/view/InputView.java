package ladder.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String readNames() {
        return scanner.nextLine();
    }

    public int readHeight() {
        return scanner.nextInt();
    }
}
