package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {

    public static void printLadderBoard(LadderBoard ladderBoard) {
        System.out.println("사다리 결과\n");
        System.out.println(ladderBoard.toString());
    }

    public static void printLadderMachingResults(GameResult gameResult, List<Player> players) {
        System.out.println("실행 결과\n");
        for (Player p : players) {
            Reward reward = gameResult.getResultReward(p);
            System.out.printf("%s : %s\n", p.getName(), reward.getName());
        }
    }

    public static void printLadderMachingResult(GameResult gameResult, Player player) {
        System.out.println("실행 결과\n");
        System.out.println(gameResult.getResultReward(player).getName());
    }
}
