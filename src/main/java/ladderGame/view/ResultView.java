package ladderGame.view;

import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;

public class ResultView {
    private static final String RESULT_PROMPT = "실행 결과";
    private static final String BLANK_MARK = "     ";
    private static final String NOT_DRAWN_MARK = "     ";
    private static final String DRAWN_MARK = "-----";
    private static final String LINE_MARK = "|";

    public void printLadder(List<Player> players, List<Line> lines) {
        printResultPrompt();
        printPlayerNames(players);
        printLines(lines);
    }

    private void printResultPrompt() {
        System.out.println(System.lineSeparator() + RESULT_PROMPT + System.lineSeparator());
    }

    private void printPlayerNames(List<Player> players) {
        players.forEach(player -> System.out.printf("%6s", player.getName()));
        System.out.println();
    }

    private void printLines(List<Line> lines) {
        lines.forEach(line -> System.out.println(makeLineToString(line)));
    }

    private String makeLineToString(Line line) {
        List<Boolean> isDrawns = line.getIsDrawns();
        StringBuilder sb = new StringBuilder();

        sb.append(BLANK_MARK + LINE_MARK);
        for (Boolean isDrawn : isDrawns) {
            sb.append(checkDrawnMark(isDrawn)).append(LINE_MARK);
        }
        return sb.toString();
    }

    private String checkDrawnMark(Boolean isDrawn) {
        if (isDrawn) {
            return DRAWN_MARK;
        }
        return NOT_DRAWN_MARK;
    }
}
