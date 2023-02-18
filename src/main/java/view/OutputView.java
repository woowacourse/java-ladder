package view;

import domain.Line;
import domain.Player;
import domain.Way;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String BAR = "|";

    public void printResult(List<Player> players, List<Line> lines, int maxPlayerNameLength) {
        players.forEach(name -> System.out.printf("%" + maxPlayerNameLength + "s ",name.getPlayerName().getName()));
        System.out.println();
        lines.forEach(line -> System.out.println(changeFormat(line, maxPlayerNameLength)));
    }

    private String changeFormat(Line line, int maxPlayerNameLength) {
        List<Boolean> points = line.getPoints();
        StringBuilder ladderLine = new StringBuilder(BLANK.repeat(maxPlayerNameLength - 1) + BAR);
        for (Boolean point : points) {
            ladderLine.append(tranceFrom(maxPlayerNameLength,point));
        }
        return ladderLine.toString();
    }

    public String tranceFrom(int maxPlayerNameLength,boolean isExist) {
        return Way.tranceFrom(isExist).repeat(maxPlayerNameLength)+BAR;
    }
}
