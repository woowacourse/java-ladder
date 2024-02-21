package ladderGame.view;

import ladderGame.model.Line;
import ladderGame.model.Player;

import java.util.List;

public class ResultView {
    private static final String RESULT_PROMPT = "실행 결과";

    public void printLadder(List<Player> players, List<Line> lines) {
        printResultPrompt();
        printPlayerNames(players);
        printLines(lines);
    }

    private void printResultPrompt() {
        System.out.println(System.lineSeparator() + RESULT_PROMPT + System.lineSeparator());
    }

    private void printPlayerNames(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%6s", player.getName());
        }
        System.out.println();
    }

    private void printLines(List<Line> lines) {
        for(Line line : lines) {
            List<Boolean> isDrawn = line.getIsDrawn();
            printLine(isDrawn);
        }
    }

    private void printLine(List<Boolean> isDrawn) {
        System.out.print("     ");
        for(Boolean space : isDrawn) {
            System.out.print("|");
            if(space) {
                System.out.print("-----");
                continue;
            }
            System.out.print("     ");
        }
        System.out.println("|");
    }
}
