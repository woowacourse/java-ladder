package ladder.view;

import java.util.List;

public class OutputView {

    public static void printResult(String names, List<String> lines) {
        System.out.println("실행결과");
        printNames(names);
        printLadder(lines);
    }

    private static void printLadder(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static void printNames(String names) {
        System.out.println(names);
    }
}
