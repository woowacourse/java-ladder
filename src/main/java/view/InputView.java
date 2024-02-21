package view;

import java.util.List;
import java.util.Scanner;
import parser.NameParser;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputNames() {
        String text = scanner.next();
        return NameParser.parse(text);
    }
}
