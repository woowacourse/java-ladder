package laddergame.view;

import laddergame.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NON_HANDLE = "     |";
    private static final String HANDLE = "-----|";
    private static final String SEE_ALL = "all";

    public static void printGameBoard(PlayerGroup playerGroup, Ladder ladder, PrizeGroup prizeGroup) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPlayers(playerGroup));
        stringBuilder.append(getLadder(ladder));
        stringBuilder.append(getPrizes(prizeGroup));

        System.out.println(stringBuilder.toString());
    }

    private static String getPlayers(PlayerGroup playerGroup) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Player> players = playerGroup.getPlayers();

        for (Player player : players) {
            stringBuilder.append(String.format("%6s", player.getName()));
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    private static String getLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            int width = line.getWidth();
            stringBuilder.append(NON_HANDLE);
            for (int i = 0; i < width; i++) {
                stringBuilder.append(line.getHandle(i) ? HANDLE : NON_HANDLE);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    private static String getPrizes(PrizeGroup prizeGroup) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Prize> prizes = prizeGroup.getPrizes();

        for (Prize prize : prizes) {
            stringBuilder.append(String.format("%6s", prize.getPrize()));
        }

        return stringBuilder.toString();
    }

    public static void printResult(GameResult gameResult, Player player) {
        System.out.println("실행 결과");

        if (player.getName().equals(SEE_ALL)) {
            System.out.println(printAllResult(gameResult));
            return;
        }

        try {
            Prize prize = gameResult.getRequestedPrize(player);
            System.out.println(player.getName() + " : " + prize.getPrize());
        } catch (IllegalArgumentException e) {
            System.out.println("일치하는 플레이어의 이름이 존재하지 않습니다.\n다시 입력해주세요.");
        }
    }

    private static String printAllResult(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();

        Map<Player, Prize> results = gameResult.getAllResult();
        List<Player> players = new ArrayList<>(results.keySet());
        List<Prize> prizes = new ArrayList<>(results.values());

        for (int i = 0; i < results.size(); i++) {
            stringBuilder.append(players.get(i).getName()).append(" : ").append(prizes.get(i).getPrize());
        }

        return stringBuilder.toString();
    }
}
