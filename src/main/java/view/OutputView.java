package view;

import domain.Line;
import util.Way;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String BAR = "|";
    private static final String ERROR_PREFIX = "[ERROR]";

    public void printResult(List<String> playersName, List<Line> lines, int maxPlayerNameLength) {
        playersName.forEach(name -> System.out.printf("%" + maxPlayerNameLength + "s ",name));
        System.out.println();
        lines.forEach(line -> System.out.println(changeFormat(line, maxPlayerNameLength)));
    }

    public String printLine(Boolean point, int maxPlayerNameLength) {
        if (point) {
            return Way.valueOf(maxPlayerNameLength).getWay() + BAR;
        }
        return Way.valueOf(maxPlayerNameLength).getBlank() + BAR;
    }

    public void printErrormessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    private String changeFormat(Line line, int maxPlayerNameLength) {
        List<Boolean> points = line.getPoints();
        StringBuilder ladderLine = new StringBuilder(BLANK.repeat(maxPlayerNameLength - 1) + BAR);
        for (Boolean point : points) {
            ladderLine.append(printLine(point, maxPlayerNameLength));
        }
        return ladderLine.toString();
    }
}
