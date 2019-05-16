package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public InputView() {
    }

    public List<String> readName() {
        System.out.println(ConsoleMessages.INPUT_NAME.message());
        Scanner scanner = new Scanner(System.in);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int readHeight() {
        System.out.println(ConsoleMessages.INPUT_HEIGHT.message());
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
