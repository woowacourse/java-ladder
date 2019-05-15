package ladder.View;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    public String getNames() {
        return scanner.nextLine();
    }

    public int getLadderHeight() {
        return scanner.nextInt();
    }
}
