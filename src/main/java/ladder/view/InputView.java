package ladder.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String readNames() {
        return scanner.nextLine();
    }
}
