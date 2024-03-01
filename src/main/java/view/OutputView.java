package view;

import domain.*;

import java.util.List;
import java.util.Map;
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

    public void printLadderResult(final Names names, final Ladder ladder, final Results results) {
        printLadderResultMessage();
        printNames(names.getValues());
        printLadder(ladder.getLines());
        printResults(results.getValues());
    }

    private void printLadderResultMessage() {
        System.out.println(System.lineSeparator() + "사다리 결과");
    }

    private void printNames(List<Name> names) {
        StringJoiner nameJoiner = new StringJoiner(DELIMITER);
        for (final Name name : names) {
            nameJoiner.add(String.format("%5s", name.getValue()));
        }
        System.out.println(System.lineSeparator() + nameJoiner);
    }

    private void printLadder(List<Line> lines) {
        StringJoiner lineJoiner = new StringJoiner(System.lineSeparator());
        for (final Line line : lines) {
            lineJoiner.add(makeLineView(line));
        }
        System.out.println(lineJoiner);
    }

    private void printResults(List<Result> results) {
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

    public void printResult(Result result) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(result.getValue());
    }

    public void printPlayerResult(Map<Name, Result> playerResults) {
        printPlayerResultMessage();
        for (final Map.Entry<Name, Result> entry : playerResults.entrySet()) {
            String name = entry.getKey().getValue();
            String result = entry.getValue().getValue();
            System.out.println(name + " : " + result);
        }
    }

    private void printPlayerResultMessage() {
        System.out.println(System.lineSeparator() + "실행 결과");
    }
}
