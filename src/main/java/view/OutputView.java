package view;

import domain.ladder.DirectionalRung;
import domain.ladder.Ladder;
import domain.ladder.LadderRow;
import domain.player.Players;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String CONNECTED_RUNG = "-";
    private static final String NOT_CONNECTED_RUNG = " ";
    private static final String LADDER_COLUMN = "|";
    public static final String SPACE = " ";

    public static void printPlayerNames(Players players) {
        StringBuilder stringBuilder = new StringBuilder();

        int maxLength = players.findMaxNameLength();
        players.getNames()
                .stream()
                .map(name -> alignStringCenter(name.getValue(), maxLength + 1))
                .forEach(stringBuilder::append);

        System.out.println(stringBuilder);
    }

    private static String alignStringCenter(String input, int length) {
        int spaces = length - input.length();
        int left = spaces / 2;
        int right = spaces - left;
        return SPACE.repeat(left) + input + SPACE.repeat(right);
    }

    public static void printLadder(Ladder ladder, int length) {
        ladder.getRows()
                .stream()
                .map(LadderRow::getRungs)
                .forEach(rungs -> System.out.println(makeLadderRowText(rungs, length)));
    }

    private static String makeLadderRowText(List<DirectionalRung> rungs, int length) {
        return SPACE.repeat(length) +
                rungs.stream()
                        .map(rung -> makeLadderRungText(rung, length))
                        .collect(Collectors.joining(LADDER_COLUMN, LADDER_COLUMN, LADDER_COLUMN));
    }

    private static String makeLadderRungText(DirectionalRung rung, int length) {
        if (rung == DirectionalRung.RIGHT) {
            return CONNECTED_RUNG.repeat(length);
        }
        return NOT_CONNECTED_RUNG.repeat(length);
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
