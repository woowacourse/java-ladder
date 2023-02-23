package ladder.view;

import java.util.List;
import java.util.Map;
import ladder.domain.Bar;
import ladder.domain.Line;

public class OutputView {
    private static final String WIDTH_PREFIX = "    ";
    private static final String WIDTH_SUFFIX = "|";
    private static final String MOVABLE_BAR = "|-----";
    private static final String IMMOVABLE_BAR = "|     ";
    private static final String BLANK = " ";
    private static final int DEFAULT_NAME_LENGTH = 6;

    public void printPlayers(List<String> playerNames) {
        for (String playerName : playerNames) {
            printNameOnSquares(playerName);
        }
        System.out.println();
    }

    private void printNameOnSquares(String playerName) {
        int nameLength = playerName.length();
        System.out.print(BLANK.repeat(DEFAULT_NAME_LENGTH - nameLength));
        System.out.print(playerName);
    }

    public void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(WIDTH_PREFIX);
        for (Bar bar : line.getBars()) {
            printBar(bar);
        }
        System.out.println(WIDTH_SUFFIX);
    }

    private void printBar(Bar bar) {
        if (bar.isMovable()) {
            System.out.print(MOVABLE_BAR);
            return;
        }
        System.out.print(IMMOVABLE_BAR);
    }

    public void printItems(List<String> itemNames) {
        for (String itemName : itemNames) {
            printNameOnSquares(itemName);
        }
        System.out.println();
    }

    public void printResult(Map<String, String> result) {
        printResultMessage();
        if (result.size() != 1) {
            printAllResult(result);
            return;
        }
        for (String name : result.keySet()) {
            System.out.println(result.get(name));
        }
    }

    private void printAllResult(Map<String, String> result) {
        for (String name : result.keySet()) {
            System.out.println(name + " : " + result.get(name));
        }
    }

    private void printResultMessage() {
        System.out.println("실행 결과");
    }
}
