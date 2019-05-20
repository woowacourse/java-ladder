package laddergame.view;

import laddergame.domain.*;

import java.util.List;

public class OutputView {
    private static final String NON_HANDLE = "     |";
    private static final String HANDLE = "-----|";

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

    public static void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
