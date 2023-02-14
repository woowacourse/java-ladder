package view;

import java.util.List;
import java.util.Scanner;

import utils.StringParser;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readUserNames() {
        String userNames = scanner.nextLine();
        return StringParser.splitByComma(userNames);
    }

    public static int readLadderHeight() {
        String ladderHeight = scanner.nextLine();
        return StringParser.parseToInteger(ladderHeight);
    }
}
