package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public InputView() {
    }


    public List<String> readName() {
        Scanner scanner = new Scanner(System.in);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int readHeight() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
