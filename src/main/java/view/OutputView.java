package view;

import domain.Bridge;
import domain.Line;
import domain.Name;
import domain.Result;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String DELIMITER = " ";
    private static final String FIRST_COLUMN = "    |";
    private static final String COLUMN = "|";
    private static final String BRIDGE = "-----";
    private static final String NO_BRIDGE = "     ";

    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printLadderResultMessage() {
        System.out.println(System.lineSeparator() + "사다리 결과");
    }

    public void printNames(List<Name> names) {
        StringJoiner nameJoiner = new StringJoiner(DELIMITER);
        for (final Name name : names) {
            nameJoiner.add(String.format("%5s", name.getValue()));
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

    public void printResults(List<Result> results){
        StringJoiner nameJoiner = new StringJoiner(DELIMITER);
        for (final Result result : results) {
            nameJoiner.add(String.format("%5s", result.getValue()));
        }
        System.out.println(nameJoiner);
    }

    private String makeLineView(final Line line) {
        StringJoiner bridgeJoiner = new StringJoiner(COLUMN, FIRST_COLUMN, COLUMN);
        for (Bridge bridge : line.getBridges()) {
            bridgeJoiner.add(exists(bridge));
        }
        return bridgeJoiner.toString();
    }

    private String exists(final Bridge bridge) {
        if (bridge.exists()) {
            return BRIDGE;
        }
        return NO_BRIDGE;
    }

    public void printPlayerResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printPlayerResult(String name, String result) {
        System.out.println(name + " : " + result);
    }
}
