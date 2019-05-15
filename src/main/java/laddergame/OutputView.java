package laddergame;

import laddergame.domain.Line;
import laddergame.domain.Player;
import laddergame.domain.Players;

import java.util.List;

public class OutputView {

    private OutputView(){
    }

    public static void showResult(Players players, List<Line> lines) {
        System.out.println("실행결과");
        showPlayers(players);
        showLadder(lines);
    }

    public static void showPlayers(Players players) {
        System.out.println(players);
    }

    private static void showLadder(List<Line> lines) {
        for (Line line : lines) {
            showLine(line);
        }
    }

    private static void showLine(Line line) {
        System.out.println(line);
    }
}
