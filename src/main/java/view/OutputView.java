package view;

import domain.Line;

import java.util.List;

public class OutputView {
    private static final String WAY_CHARACTER = "-";
    private static final String BLANK = " ";
    private static final String BAR = "|";

    public void printResult(List<String> playersName, List<Line> lines, int maxPlayerNameLength) {
        playersName.forEach(name -> System.out.printf("%" + maxPlayerNameLength + "s ",name));
        System.out.println();
        lines.forEach(line -> System.out.println(changeFormat(line, maxPlayerNameLength)));
    }

    private String changeFormat(Line line, int maxPlayerNameLength) {
        List<Boolean> points = line.getPoints();
        StringBuilder ladderLine = new StringBuilder(BLANK.repeat(maxPlayerNameLength-1)+BAR);
        for (Boolean point : points) {
            ladderLine.append(printLine(point, maxPlayerNameLength));
        }
        return ladderLine.toString();
    }

    public String printLine(Boolean point, int maxPlayerNameLength) {
        if (point) {
            return WAY_CHARACTER.repeat(maxPlayerNameLength) + BAR;
        }
        return BLANK.repeat(maxPlayerNameLength) + BAR;
    }
}
