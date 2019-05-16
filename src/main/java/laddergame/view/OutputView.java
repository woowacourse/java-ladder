package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Player;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void showResult(List<Player> players, Ladder ladder) {
        System.out.println("실행 결과");
        showPlayers(players);
        System.out.println(ladder);
    }

    private static void showPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.print(player + " ");
        }
        System.out.println();
    }
}
