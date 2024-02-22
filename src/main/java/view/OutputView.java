package view;

import domain.Bridge;
import domain.Line;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String NAME_DELIMITER = " ";
    private static final String FIRST_COLUMN = "    |";
    private static final String COLUMN = "|";

    private static String makeLineView(final Line line) {
        StringJoiner bridgeJoiner = new StringJoiner(COLUMN, FIRST_COLUMN, COLUMN);
        for (Bridge bridge : line.getBridges()) {
            bridgeJoiner.add(bridge.getShape());
        }
        return bridgeJoiner.toString();
    }

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행결과");
    }

    public void printPlayers(List<String> names) {
        StringJoiner nameJoiner = new StringJoiner(NAME_DELIMITER);
        for (final String name : names) {
            nameJoiner.add(String.format("%5s", name));
        }
        System.out.println(System.lineSeparator() + nameJoiner);
    }

    public void printLadder(List<Line> lines) {
        StringJoiner lineJoiner = new StringJoiner(System.lineSeparator());
        for (final Line line : lines) {
            lineJoiner.add(makeLineView(line));
        }
        System.out.println(lineJoiner);
    }
}
