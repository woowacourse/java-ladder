package ladder.view;

import ladder.domain.Crossbars;
import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.PlayerGroup;

public class OutputView {
    public static void showPlayersAndLadder(PlayerGroup players, Ladder ladder) {
        System.out.println("실행 결과\n");
        for (Player player : players.getPlayers()) {
            System.out.print(String.format("%6s", player));
        }
        System.out.println();

        for (Crossbars crossbars : ladder.getLadder()) {
            printCrossbars(crossbars);
            System.out.println();
        }
    }

    private static void printCrossbars(Crossbars crossbars) {
        int dummy_index = crossbars.getCrossbars().size();

        for (int i = 0; i < dummy_index - 1; i++) {
            if (crossbars.getCrossbars().get(i)) {
                System.out.print("-----|");
                continue;
            }
            System.out.print(String.format("%6s","|"));
        }
    }
}
