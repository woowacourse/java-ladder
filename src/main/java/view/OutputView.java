package view;

import domain.Line;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String BAR = "|";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult(List<String> playersName, List<Line> lines, int maxPlayerNameLength) {
        playersName.forEach(name -> System.out.printf("%" + maxPlayerNameLength + "s ", name));
        System.out.println();
        lines.forEach(line -> System.out.println(changeFormat(line, maxPlayerNameLength)));
    }

    public void printErrormessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    private String changeFormat(Line line, int maxPlayerNameLength) {
        int preBlankLength = maxPlayerNameLength - 1;
        List<Boolean> points = line.getPoints();
        StringBuilder ladderLine = new StringBuilder(BLANK.repeat(preBlankLength) + BAR);
        for (Boolean point : points) {
            ladderLine.append(printLine(point, maxPlayerNameLength));
        }
        return ladderLine.toString();
    }

    private String printLine(Boolean point, int maxPlayerNameLength) {
        return LadderStep.valueOf(point).getStep().repeat(maxPlayerNameLength) + BAR;
    }
}
