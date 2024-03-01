package view;

import domain.Prize;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLadderResultMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public void printPlayerNames(List<String> playerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String playerName : playerNames) {
            stringBuilder.append(String.format("%5s ", playerName));
        }

        System.out.println(stringBuilder);
    }

    public void printLadder(String ladder) {
        System.out.println(ladder);
    }

    public void printPrizes(List<Prize> prizes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Prize prize : prizes) {
            stringBuilder.append(String.format("%5s ", prize.getPrize()));
        }

        System.out.println(stringBuilder);
    }

    public void printResultMessage() {
        System.out.print("\n실행결과\n");
    }

    public void printPlayerResult(String prize) {
        System.out.println(prize);
    }

    public void printAllPlayerResults(Map<String, String> results) {
        for (String name : results.keySet()) {
            System.out.println(name + " : " + results.get(name));
        }
    }
}
