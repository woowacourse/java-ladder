package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Player;

import java.util.List;

public class OutputView {

    public static void printLadder(List<Player> players, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player));
            //System.out.printf("%6s", player.toString() + "\n");
        }
        stringBuilder.append("\n").append(ladder).append("\n");

        System.out.println(stringBuilder.toString());
    }
}
