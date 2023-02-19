package view;

import domain.Ladder;
import domain.Line;
import domain.Players;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String BAR = "|";

    public void printResult(Players players, Ladder ladder) {
        players.getPlayers().forEach(name -> System.out.printf("%" + players.getMaxPlayerNameLength() + "s ",name.getPlayerName()));
        System.out.println();
        ladder.getLines().forEach(line -> System.out.println(changeFormat(line, players.getMaxPlayerNameLength())));
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
