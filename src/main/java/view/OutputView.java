package view;

import domain.ladder.Ladder;
import domain.ladder.LadderRow;
import domain.ladder.LadderRung;
import domain.player.PlayerNames;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DISCONNECTED_RUNG = " ";
    private static final String CONNECTED_RUNG = "-";
    private static final String LADDER_SIDE = "|";

    public static void printPlayerNames(PlayerNames playerNames) {
        int maxLength = playerNames.findMaxNameLength();
        playerNames.getNames().stream()
                .map(name -> alignNameCenter(name, maxLength + 1))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String alignNameCenter(String name, int length) {
        int spaces = length - name.length();
        int left = spaces / 2;
        int right = spaces - left;
        return " ".repeat(left) + name + " ".repeat(right);
    }

    public static void printLadder(int length, Ladder ladder) {
        ladder.getRows()
                .stream()
                .map(LadderRow::getRungs)
                .forEach(rungs -> System.out.println(makeMessage(rungs, length)));
    }

    private static String makeMessage(List<LadderRung> rungs, int length) {
        return " ".repeat(length) + rungs.stream()
                .map(rung -> makeRung(length, rung))
                .collect(Collectors.joining(LADDER_SIDE, LADDER_SIDE, LADDER_SIDE));
    }

    private static String makeRung(int length, LadderRung rung) {
        if (rung.isConnected()) {
            return CONNECTED_RUNG.repeat(length);
        }
        return DISCONNECTED_RUNG.repeat(length);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
