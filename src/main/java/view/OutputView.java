package view;

import domain.Player;
import domain.Prize;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLadderResultMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public void printLadderResult(List<String> playerNames, String ladder, List<Prize> prizes) {
        printPlayerNames(playerNames);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void printPlayerNames(List<String> playerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String playerName : playerNames) {
            stringBuilder.append(String.format("%5s ", playerName));
        }

        System.out.println(stringBuilder);
    }

    private void printLadder(String ladder) {
        System.out.println(ladder);
    }

    private void printPrizes(List<Prize> prizes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Prize prize : prizes) {
            stringBuilder.append(String.format("%5s ", prize.getPrize()));
        }

        System.out.println(stringBuilder);
    }

    public void printResultMessage() {
        System.out.print("\n실행결과\n");
    }

    public void printAllPlayerResults(Map<Player, Prize> playerResults) {
        for (Player player : playerResults.keySet()) {
            System.out.println(player.getName() + " : " + playerResults.get(player).getPrize());
        }
    }

    public void printPlayerResult(String prize) {
        System.out.println(prize);
    }
}
