package view;

import java.util.List;
import model.Line;

public class OutputView {
    public void printResult(List<String> names, List<Line> lines) {
        System.out.printf("%n실행결과%n%n");
        printPlayers(names);
        printLadder(names.get(0).length(), lines);
    }

    private void printPlayers(List<String> names) {
        String value = Formatter.formatPlayers(names);
        System.out.println(value);
    }

    private void printLadder(int paddingSize, List<Line> lines) {
        String value = Formatter.formatLadder(paddingSize, lines);
        System.out.printf(value);
        System.out.println();
    }
}
