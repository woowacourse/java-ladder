package view;

import java.util.List;

import domain.Line;
import domain.PlayerName;
import domain.Players;

public class OutputView {
    private static final String BRIDGE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String BLANK_LINE = "     ";
    private static final String BLANK = " ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String LADDER_RESULT = "실행 결과";
    private static final String DELIMITER = " : ";

    public void printErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public void printSinglePlayerResult(String prize) {
        System.out.println(LADDER_RESULT);
        System.out.println(prize);
    }

    public void printAllPlayerResult(Players players, List<String> resultPrizes) {
        System.out.println(LADDER_RESULT);
        for (int i = 0; i < players.getCount(); i++) {
            System.out.println(players.getNames().get(i) + DELIMITER + resultPrizes.get(i));
        }
    }

    public void printLadder(List<Line> lines) {
        StringBuilder builder = new StringBuilder();
        for (Line line : lines) {
            appendLine(builder, line);
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);
    }

    public void printNames(List<String> names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name)
                    .append(getNameBlank(name))
                    .append(BLANK);
        }
        System.out.println(stringBuilder);
    }

    private void appendLine(StringBuilder builder, Line line) {
        builder.append(VERTICAL_LINE);
        for (int pointIndex = 0; pointIndex < line.getPointsSize(); pointIndex++) {
            appendPoint(builder, line, pointIndex);
        }
        builder.append("\n");
    }

    private void appendPoint(StringBuilder builder, Line line, int pointIndex) {
        if (line.isMovablePoint(pointIndex)) {
            builder.append(BRIDGE);
        }
        if (!line.isMovablePoint(pointIndex)) {
            builder.append(BLANK_LINE);
        }
        builder.append(VERTICAL_LINE);
    }

    private String getNameBlank(String name) {
        return BLANK.repeat(PlayerName.MAX_LENGTH - name.length());
    }

}
