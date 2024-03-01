package view;

import domain.ladder.Ladder;
import domain.ladder.LadderRow;
import domain.ladder.LadderRung;
import domain.player.Players;
import domain.prize.Prizes;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final int EMPTY_COUNT = 1;
    private static final String EMPTY_SPACE = " ";
    private static final String DISCONNECTED_RUNG_CHARACTER = " ";
    private static final String CONNECTED_RUNG_CHARACTER = "-";
    private static final String LADDER_SIDE_CHARACTER = "|";

    private OutputView() {
    }

    public static void printLadder(Ladder ladder, Players players, Prizes prizes) {
        System.out.println("사다리 결과" + System.lineSeparator());
        int maxLength = Math.max(players.findMaxNameLength(), prizes.findMaxPrizeNameLength());
        printPlayerNames(players, maxLength);
        printLadder(ladder, maxLength);
        printPrizes(prizes, maxLength);
    }

    private static void printPlayerNames(Players players, int maxLength) {
        players.getPlayerNames().stream()
                .map(name -> alignCenter(name, maxLength + EMPTY_COUNT))
                .forEach(System.out::print);
        System.out.println();
    }

    private static String alignCenter(String name, int length) {
        int spaces = length - name.length();
        int left = spaces / 2;
        int right = spaces - left;
        return EMPTY_SPACE.repeat(left) + name + EMPTY_SPACE.repeat(right);
    }

    private static void printLadder(Ladder ladder, int maxLength) {
        ladder.getRows()
                .stream()
                .map(LadderRow::getRungs)
                .forEach(rungs ->
                        System.out.printf("%s%s%n", EMPTY_SPACE.repeat(maxLength), makeRungMessage(rungs, maxLength))
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

    private static void printPrizes(Prizes prizes, int maxLength) {
        prizes.getPrizes().stream()
                .map(prize -> alignCenter(prize, maxLength + EMPTY_COUNT))
                .forEach(System.out::print);
        System.out.println(System.lineSeparator());
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printSinglePlayerResult(String prize) {
        System.out.println("실행 결과");
        System.out.println(prize);
        System.out.println();
    }

    public static void printAllPlayerResult(Map<String, String> results) {
        System.out.println("실행 결과");
        results.forEach((name, prize) -> System.out.println(name + " : " + prize));
    }
}
