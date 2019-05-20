package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Player;
import laddergame.domain.PlayerGroup;
import laddergame.domain.Prize;

import java.util.List;

public class OutputView {

    public static void printLadder(PlayerGroup playerGroup, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Player> players = playerGroup.getPlayers();
        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.getName()));
        }
        stringBuilder.append("\n").append(ladder);

        System.out.print(stringBuilder.toString());
    }

    public static void printPrizes(List<Prize> prizes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Prize prize : prizes) {
            stringBuilder.append(String.format("%6s", prize));
        }

        System.out.println(stringBuilder.toString());
    }

    public static void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
