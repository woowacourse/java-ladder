package view;

import domain.ladder.Ladder;
import domain.ladder.LadderRow;
import domain.ladder.LadderRung;
import domain.player.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int EMPTY_COUNT = 1;
    private static final String EMPTY_SPACE = " ";
    private static final String DISCONNECTED_RUNG_CHARACTER = " ";
    private static final String CONNECTED_RUNG_CHARACTER = "-";
    private static final String LADDER_SIDE_CHARACTER = "|";

    private OutputView() {
    }

    public static void printPlayerNames(Players players) {
        int maxLength = players.findMaxNameLength();
        players.getNames().stream()
                .map(name -> alignNameCenter(name, maxLength + EMPTY_COUNT))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String alignNameCenter(String name, int length) {
        int spaces = length - name.length();
        int left = spaces / 2;
        int right = spaces - left;
        return EMPTY_SPACE.repeat(left) + name + EMPTY_SPACE.repeat(right);
    }

    public static void printLadder(int length, Ladder ladder) {
        ladder.getRows()
                .stream()
                .map(LadderRow::getRungs)
                .forEach(rungs ->
                        System.out.printf("%s%s%n", EMPTY_SPACE.repeat(length), makeRungMessage(rungs, length))
                );
    }

    private static String makeRungMessage(List<LadderRung> rungs, int length) {
        return rungs.stream()
                .map(rung -> getRungCharacter(length, rung))
                .collect(Collectors.joining(LADDER_SIDE_CHARACTER, LADDER_SIDE_CHARACTER, LADDER_SIDE_CHARACTER));
    }

    private static String getRungCharacter(int length, LadderRung rung) {
        if (rung.isConnected()) {
            return CONNECTED_RUNG_CHARACTER.repeat(length);
        }
        return DISCONNECTED_RUNG_CHARACTER.repeat(length);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
